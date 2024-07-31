package hackerton.wakeup.body.own.controller;

import hackerton.wakeup.body.own.entity.dto.response.AllOwnBodyResponseDTO;
import hackerton.wakeup.body.own.service.OwnBodyAvatarService;
import hackerton.wakeup.character.entity.Character;
import hackerton.wakeup.character.service.CharacterService;
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
@RequestMapping("/api/own/body")
public class OwnBodyAvatarController {
    private final OwnBodyAvatarService ownBodyAvatarService;
    private final MemberService memberService;
    private final CharacterService characterService;

    @GetMapping("/owns")
    @ResponseBody
    public ResponseEntity<List<AllOwnBodyResponseDTO>> getAllOwnBodyAvatars(Authentication auth) {
        Member member = memberService.getMemberByEmail(auth.getName()).get();
        Character character = characterService.getByMemberId(member.getId());
        List<AllOwnBodyResponseDTO> allOwnBodyAvatars = ownBodyAvatarService.getAllOwnBodyAvatars(character.getId());
        return ResponseEntity.ok(allOwnBodyAvatars);
    }
}
