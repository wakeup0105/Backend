package hackerton.wakeup.character.controller;

import hackerton.wakeup.body.own.entity.dto.response.BuyBodyResponseDTO;
import hackerton.wakeup.body.own.service.OwnBodyAvatarService;
import hackerton.wakeup.character.entity.Character;
import hackerton.wakeup.character.entity.dto.request.BuyRequestDTO;
import hackerton.wakeup.character.entity.dto.response.CustomizeResponseDTO;
import hackerton.wakeup.character.entity.dto.response.GrowResponseDTO;
import hackerton.wakeup.character.service.CharacterService;
import hackerton.wakeup.eyes.own.entity.dto.response.BuyEyesResponseDTO;
import hackerton.wakeup.eyes.own.service.OwnEyesAvatarService;
import hackerton.wakeup.head.own.entity.dto.response.BuyHeadResponseDTO;
import hackerton.wakeup.head.own.service.OwnHeadAvatarService;
import hackerton.wakeup.member.entity.Member;
import hackerton.wakeup.member.service.MemberService;
import hackerton.wakeup.mouth.own.entity.dto.response.BuyMouthResponseDTO;
import hackerton.wakeup.mouth.own.service.OwnMouthAvatarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/character")
public class CharacterController {
    private final CharacterService characterService;
    private final MemberService memberService;
    private final OwnEyesAvatarService ownEyesAvatarService;
    private final OwnMouthAvatarService ownMouthAvatarService;
    private final OwnHeadAvatarService ownHeadAvatarService;
    private final OwnBodyAvatarService ownBodyAvatarService;

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
        return ResponseEntity.ok(GrowResponseDTO.fromEntity(findCharacter));
    }

    @GetMapping("/info-customize")
    @ResponseBody
    public ResponseEntity<CustomizeResponseDTO> userInfoCustomize(Authentication auth){
        Member member = memberService.getMemberByEmail(auth.getName()).get();
        Character findCharacter = characterService.getByMemberId(member.getId());
        return ResponseEntity.ok(CustomizeResponseDTO.fromEntity(findCharacter));
    }

    @PostMapping("/buy")
    @ResponseBody
    public ResponseEntity<?> buy(@Valid @RequestBody BuyRequestDTO req, Authentication auth){
        Member member = memberService.getMemberByEmail(auth.getName()).get();
        switch (req.getPart()){
            case "eyes": {
                BuyEyesResponseDTO res = ownEyesAvatarService.buyEyes(member, req.getName());
                if (res==null) return new ResponseEntity<>("포인트 부족", HttpStatus.BAD_REQUEST);
                return ResponseEntity.ok(res);
            }
            case "mouth": {
                BuyMouthResponseDTO res = ownMouthAvatarService.buyMouth(member, req.getName());
                if (res == null) return new ResponseEntity<>("포인트 부족", HttpStatus.BAD_REQUEST);
                return ResponseEntity.ok(res);
            }
            case "head": {
                BuyHeadResponseDTO res = ownHeadAvatarService.buyHead(member, req.getName());
                if (res == null) return new ResponseEntity<>("포인트 부족", HttpStatus.BAD_REQUEST);
                return ResponseEntity.ok(res);
            }
            case "body": {
                BuyBodyResponseDTO res = ownBodyAvatarService.buyBody(member, req.getName());
                if (res == null) return new ResponseEntity<>("포인트 부족", HttpStatus.BAD_REQUEST);
                return ResponseEntity.ok(res);
            }
            default: return new ResponseEntity<>("잘못된 요청", HttpStatus.BAD_REQUEST);
        }
    }
}
