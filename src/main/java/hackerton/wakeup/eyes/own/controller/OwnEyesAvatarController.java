package hackerton.wakeup.eyes.own.controller;

import hackerton.wakeup.character.service.CharacterService;
import hackerton.wakeup.eyes.own.service.OwnEyesAvatarService;
import hackerton.wakeup.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/own/eyes")
public class OwnEyesAvatarController {
    private final MemberService memberService;
    private final CharacterService characterService;
    private final OwnEyesAvatarService ownEyesAvatarService;
}
