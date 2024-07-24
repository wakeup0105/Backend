package hackerton.wakeup.memberInfo.controller;

import hackerton.wakeup.memberInfo.service.MemberInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member-info")
public class MemberInfoController {
    private final MemberInfoService memberInfoService;
}
