package hackerton.wakeup.memberInfo.controller;

import hackerton.wakeup.member.service.MemberService;
import hackerton.wakeup.memberInfo.entity.dto.request.SetNicknameRequestDTO;
import hackerton.wakeup.memberInfo.service.MemberInfoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member-info")
public class MemberInfoController {
    private final MemberInfoService memberInfoService;
    private final MemberService memberService;

    @PostMapping("/set-nickname")
    public ResponseEntity<String> setNickname(@Valid @RequestBody SetNicknameRequestDTO req, Authentication auth){

    }
}
