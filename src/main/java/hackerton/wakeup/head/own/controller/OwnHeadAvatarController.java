package hackerton.wakeup.head.own.controller;

import hackerton.wakeup.character.entity.Character;
import hackerton.wakeup.character.service.CharacterService;
import hackerton.wakeup.head.own.entity.dto.response.AllOwnHeadResponseDTO;
import hackerton.wakeup.head.own.service.OwnHeadAvatarService;
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
@RequestMapping("/api/own/head")
public class OwnHeadAvatarController {
    private final OwnHeadAvatarService ownHeadAvatarService;
    private final MemberService memberService;
    private final CharacterService characterService;

    @GetMapping("/owns")
    @ResponseBody
    public ResponseEntity<List<AllOwnHeadResponseDTO>> getAllOwnHeadAvatars(Authentication auth) {
        Member member = memberService.getMemberByEmail(auth.getName()).get();
        Character character = characterService.getByMemberId(member.getId());
        List<AllOwnHeadResponseDTO> allOwnHeadAvatar = ownHeadAvatarService.getAllOwnHeadAvatar(character.getId());
        return ResponseEntity.ok(allOwnHeadAvatar);
    }
}
