package hackerton.wakeup.mouth.own.controller;

import hackerton.wakeup.character.entity.Character;
import hackerton.wakeup.character.service.CharacterService;
import hackerton.wakeup.member.entity.Member;
import hackerton.wakeup.member.service.MemberService;
import hackerton.wakeup.mouth.own.entity.dto.response.AllOwnMouthResponseDTO;
import hackerton.wakeup.mouth.own.service.OwnMouthAvatarService;
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
@RequestMapping("/api/own/mouth")
public class OwnMouthAvatarController {
    private final OwnMouthAvatarService ownMouthAvatarService;
    private final MemberService memberService;
    private final CharacterService characterService;

    @GetMapping("/owns")
    @ResponseBody
    public ResponseEntity<List<AllOwnMouthResponseDTO>> getAllOwnMouthAvatar(Authentication auth) {
        Member member = memberService.getMemberByEmail(auth.getName()).get();
        Character character = characterService.getByMemberId(member.getId());
        List<AllOwnMouthResponseDTO> allOwnMouthsAvatar = ownMouthAvatarService.getAllOwnMouthsAvatar(character.getId());
        return ResponseEntity.ok(allOwnMouthsAvatar);
    }
}
