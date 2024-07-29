package hackerton.wakeup.eyes.own.controller;

import hackerton.wakeup.character.entity.Character;
import hackerton.wakeup.character.service.CharacterService;
import hackerton.wakeup.eyes.own.entity.OwnEyesAvatar;
import hackerton.wakeup.eyes.own.service.OwnEyesAvatarService;
import hackerton.wakeup.member.entity.Member;
import hackerton.wakeup.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/own/eyes")
public class OwnEyesAvatarController {
    private final MemberService memberService;
    private final CharacterService characterService;
    private final OwnEyesAvatarService ownEyesAvatarService;

    @GetMapping("/owns")
    @ResponseBody
    public ResponseEntity<List<OwnEyesAvatar>> getAllOwnEyesAvatars(Authentication auth) {
        Member member = memberService.getMemberByEmail(auth.getName()).get();
        Character character = characterService.getByMemberId(member.getId());
        ownEyesAvatarService.getAllOwnEyesAvatars(character.getId());
        return ;
    }
}
