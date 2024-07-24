package hackerton.wakeup.memberInfo.controller;

import hackerton.wakeup.member.entity.Member;
import hackerton.wakeup.member.service.MemberService;
import hackerton.wakeup.memberInfo.entity.MemberInfo;
import hackerton.wakeup.memberInfo.entity.dto.request.SetNicknameRequestDTO;
import hackerton.wakeup.memberInfo.service.MemberInfoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        Member member = memberService.getMemberByEmail(auth.getName()).get();
        String resultNickname = memberInfoService.settingNickname(member, req.getNickname());
        return ResponseEntity.ok("닉네임 설정 성공: " + resultNickname);
    }

    @GetMapping("/info")
    @ResponseBody
    public ResponseEntity<MemberInfo> findMemberInfo(Authentication auth){
        Member member = memberService.getMemberByEmail(auth.getName()).get();
        MemberInfo memberInfo = memberInfoService.findByMemberId(member.getId());
        if (memberInfo == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(memberInfo);
    }
}
