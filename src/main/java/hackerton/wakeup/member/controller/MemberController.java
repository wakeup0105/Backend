package hackerton.wakeup.member.controller;

import hackerton.wakeup.character.service.CharacterService;
import hackerton.wakeup.common.security.JwtTokenUtil;
import hackerton.wakeup.email.service.EmailVerifyService;
import hackerton.wakeup.member.entity.Member;
import hackerton.wakeup.member.entity.dto.request.*;
import hackerton.wakeup.member.entity.dto.response.JwtTokenResponseDTO;
import hackerton.wakeup.member.entity.dto.response.MyInfoResponseDTO;
import hackerton.wakeup.member.service.MemberService;
import hackerton.wakeup.memberInfo.service.MemberInfoService;
import hackerton.wakeup.refresh.entity.RefreshToken;
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
    private final CharacterService characterService;
    private final MemberInfoService memberInfoService;
    @Value("${spring.jwt.secretKey}")
    private String secretKey;
    @Value("${spring.jwt.expirationTime}")
    private String expirationTime;
    @Value("${spring.jwt.refresh-expirationTime}")
    private String refreshExpirationTime;

    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity<JwtTokenResponseDTO> join(@Valid @RequestBody JoinRequestDTO req){
        if (memberService.checkEmailDuplication(req.getEmail())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!req.getPassword().equals(req.getCheckPassword())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        memberService.joinMember(req);
        characterService.initCharacter(memberService.getMemberByEmail(req.getEmail()).get());
        memberInfoService.initMemberInfo(memberService.getMemberByEmail(req.getEmail()).get());
        String token = JwtTokenUtil.createToken(req.getEmail(), secretKey, Long.parseLong(expirationTime));
        RefreshToken refreshToken = memberService.createRefreshToken(req.getEmail());
        return ResponseEntity.ok(new JwtTokenResponseDTO(token, expirationTime, refreshToken.getToken(), refreshExpirationTime));
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<JwtTokenResponseDTO> login(@Valid @RequestBody LoginRequestDTO req){
        Member member = memberService.loginMember(req);

        //null 이라면 정보 오류
        if (member == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        String token = JwtTokenUtil.createToken(member.getEmail(), secretKey, Long.parseLong(expirationTime));
        RefreshToken refreshToken = memberService.createRefreshToken(req.getEmail());
        return ResponseEntity.ok(new JwtTokenResponseDTO(token, expirationTime, refreshToken.getToken(), refreshExpirationTime));
    }

    @PostMapping("/refresh")
    @ResponseBody
    public ResponseEntity<JwtTokenResponseDTO> refreshToken(@RequestBody RefreshRequestDTO refreshToken){
        RefreshToken verifyRefreshToken = memberService.verifyRefreshToken(refreshToken.getRefreshToken());
        if (verifyRefreshToken == null) return ResponseEntity.badRequest().build();
        String email = verifyRefreshToken.getMember().getEmail();
        String newToken = JwtTokenUtil.createToken(email, secretKey, Long.parseLong(expirationTime));
        return ResponseEntity.ok(new JwtTokenResponseDTO(newToken, expirationTime, refreshToken.getRefreshToken(), refreshExpirationTime));
    }

    @PostMapping("/find-account")
    @ResponseBody
    public ResponseEntity<JwtTokenResponseDTO> findAccount(@Valid @RequestBody FindAccountRequestDTO req){
        if (!memberService.checkEmailDuplication(req.getEmail())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
//        if(!emailVerifyService.verifyCode(req.getEmail(), req.getVerificationCode())){
//            return new ResponseEntity<>("인증코드가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
//        }
        String token = JwtTokenUtil.createToken(req.getEmail(), secretKey, Long.parseLong(expirationTime));
        RefreshToken refreshToken = memberService.createRefreshToken(req.getEmail());
        return ResponseEntity.ok(new JwtTokenResponseDTO(token, expirationTime, refreshToken.getToken(), refreshExpirationTime));
    }

    @PatchMapping("/change-password")
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
        return ResponseEntity.ok(MyInfoResponseDTO.fromEntity(member.getEmail(), member.getMemberInfo().getTag()));
    }
}
