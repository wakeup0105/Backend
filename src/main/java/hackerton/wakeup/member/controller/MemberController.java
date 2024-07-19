package hackerton.wakeup.member.controller;

import hackerton.wakeup.member.entity.dto.request.JoinRequestDTO;
import hackerton.wakeup.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
