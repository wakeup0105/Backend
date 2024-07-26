package hackerton.wakeup.character.controller;

import hackerton.wakeup.character.entity.Character;
import hackerton.wakeup.character.entity.dto.response.GrowResponseDTO;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/character")
public class CharacterController {
    private final CharacterService characterService;
    private final MemberService memberService;

    @GetMapping("/info")
    @ResponseBody
    public ResponseEntity<Character> userInfoAll(Authentication auth){
        Member member = memberService.getMemberByEmail(auth.getName()).get();
        Character findCharacter = characterService.getByMemberId(member.getId());
        return ResponseEntity.ok(findCharacter);
    }

    @GetMapping("/info-grow")
    @ResponseBody
    public ResponseEntity<GrowResponseDTO> userInfoGrow(Authentication auth){
        Member member = memberService.getMemberByEmail(auth.getName()).get();
        Character findCharacter = characterService.getByMemberId(member.getId());
        return ResponseEntity.ok(new GrowResponseDTO().toEntity(findCharacter));
    }
}
