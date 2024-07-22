package hackerton.wakeup.member.controller;

import hackerton.wakeup.member.entity.dto.request.JoinRequestDTO;
import hackerton.wakeup.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<String> join(@Valid @RequestBody JoinRequestDTO req){
        if (memberService.checkEmailDuplication(req.getEmail())){
            return new ResponseEntity<>("이메일 중복", HttpStatus.BAD_REQUEST);
        }
        if (!req.getPassword().equals(req.getCheckPassword())){
            return new ResponseEntity<>("비밀번호 불일치", HttpStatus.BAD_REQUEST);
        }
        memberService.joinMember(req);
        return ResponseEntity.ok("회원가입 성공");
    }

    @PostMapping("/send-verification")
    public ResponseEntity<String> sendVerification(@RequestParam("email") String email){
        if (memberService.checkEmailDuplication(email)){
            return new ResponseEntity<>("이미 존재하는 이메일입니다.", HttpStatus.BAD_REQUEST);
        }
        memberService.sendVerificationEmail(email);
        return ResponseEntity.ok("인증코드가 이메일로 전송 되었습니다.");
    }
}
