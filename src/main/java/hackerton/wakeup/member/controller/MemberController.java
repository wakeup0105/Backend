package hackerton.wakeup.member.controller;

import hackerton.wakeup.common.security.JwtTokenUtil;
import hackerton.wakeup.email.service.EmailVerifyService;
import hackerton.wakeup.member.entity.Member;
import hackerton.wakeup.member.entity.dto.request.ChangePasswordRequestDTO;
import hackerton.wakeup.member.entity.dto.request.FindAccountRequestDTO;
import hackerton.wakeup.member.entity.dto.request.JoinRequestDTO;
import hackerton.wakeup.member.entity.dto.request.LoginRequestDTO;
import hackerton.wakeup.member.entity.dto.response.MyInfoResponseDTO;
import hackerton.wakeup.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;
    private final EmailVerifyService emailVerifyService;
    @Value("${spring.jwt.secretKey}")
    private String secretKey;
    @Value("${spring.jwt.expirationTime}")
    private String expirationTime;

    @PostMapping("/signup")
    public ResponseEntity<String> join(@Valid @RequestBody JoinRequestDTO req){
        if (memberService.checkEmailDuplication(req.getEmail())){
            return new ResponseEntity<>("이메일 중복", HttpStatus.BAD_REQUEST);
        }
        if (!req.getPassword().equals(req.getCheckPassword())){
            return new ResponseEntity<>("비밀번호 불일치", HttpStatus.BAD_REQUEST);
        }
        memberService.joinMember(req);
        String token = JwtTokenUtil.createToken(req.getEmail(), secretKey, Long.parseLong(expirationTime));
        return ResponseEntity.ok("회원가입 성공, Token: " + token);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequestDTO req){
        Member member = memberService.loginMember(req);

        //null 이라면 정보 오류
        if (member == null) return new ResponseEntity<>("이메일 또는 비밀번호가 틀렸습니다.", HttpStatus.BAD_REQUEST);

        String token = JwtTokenUtil.createToken(member.getEmail(), secretKey, Long.parseLong(expirationTime));
        return ResponseEntity.ok(token);
    }

    @PostMapping("/find-account")
    public ResponseEntity<String> findAccount(@Valid @RequestBody FindAccountRequestDTO req){
        if (!memberService.checkEmailDuplication(req.getEmail())){
            return new ResponseEntity<>("이메일이 존재하지 않습니다.", HttpStatus.BAD_REQUEST);
        }
        if(!emailVerifyService.verifyCode(req.getEmail(), req.getVerificationCode())){
            return new ResponseEntity<>("인증코드가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
        }
        String token = JwtTokenUtil.createToken(req.getEmail(), secretKey, Long.parseLong(expirationTime));
        return ResponseEntity.ok("인증성공, Token: " + token);
    }

    @PutMapping("/change-password")
    public ResponseEntity<String> changePassword(@Valid @RequestBody ChangePasswordRequestDTO req, Authentication auth){
        Member member = memberService.getMemberByEmail(auth.getName()).get();
        if (!memberService.checkEmailDuplication(member.getEmail())){
            return new ResponseEntity<>("이메일이 존재하지 않습니다.", HttpStatus.BAD_REQUEST);
        }
        if (!req.getPassword().equals(req.getCheckPassword())){
            return new ResponseEntity<>("비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
        }
        memberService.changePassword(member.getEmail(),req);
        return ResponseEntity.ok("비밀번호 변경 성공");
    }

    @PostMapping("/send-verification")
    public ResponseEntity<String> sendVerification(@RequestParam("email") String email){
        memberService.sendVerificationEmail(email);
        return ResponseEntity.ok("인증코드가 이메일로 전송 되었습니다.");
    }

    @GetMapping("/my-info")
    @ResponseBody
    public ResponseEntity<MyInfoResponseDTO> myInfo(Authentication auth){
        Member member = memberService.getMemberByEmail(auth.getName()).get();
        return ResponseEntity.ok(new MyInfoResponseDTO().toEntity(member));
    }
}
