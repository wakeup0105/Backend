package hackerton.wakeup.eyes.own.entity.dto;

import hackerton.wakeup.character.entity.Character;
import hackerton.wakeup.eyes.own.entity.OwnEyesAvatar;
import hackerton.wakeup.eyes.own.entity.dto.response.AllOwnEyesResponseDTO;
import hackerton.wakeup.eyes.own.entity.dto.response.BuyEyesResponseDTO;
import hackerton.wakeup.eyes.part.entity.Eyes;
import hackerton.wakeup.member.entity.Member;

public class OwnEyesDtoConverter {

    public static AllOwnEyesResponseDTO allOwnEyesResponseConverter(OwnEyesAvatar res){
        AllOwnEyesResponseDTO dto = new AllOwnEyesResponseDTO();
        dto.setId(res.getId());
        dto.setCharacterId(res.getCharacter().getId().getId());
        dto.setName(res.getEyes().getName());
        dto.setPrice(res.getEyes().getPrice());
        return dto;
    }

    public static BuyEyesResponseDTO buyEyesResponseConverter(OwnEyesAvatar res){
        BuyEyesResponseDTO dto = new BuyEyesResponseDTO();
        dto.setNickname(res.getCharacter().getMember().getMemberInfo().getNickname() + "#"
        + res.getCharacter().getMember().getMemberInfo().getTag());
        dto.setAvatarName(res.getEyes().getName());
        dto.setPrice(res.getEyes().getPrice());
        dto.setPoint(res.getCharacter().getMember().getPoint());
        return dto;
    }

    public static Character equipEyesConverter(Character character, String name){
        return Character.builder()
                .id(character.getId())
                .member(character.getMember())
                .level(character.getLevel())
                .exp(character.getExp())
                .eyes(name).mouth(character.getMouth()).head(character.getHead()).body(character.getBody())
                .ownEyesAvatars(character.getOwnEyesAvatars()).ownMouthAvatars(character.getOwnMouthAvatars())
                .ownHeadAvatars(character.getOwnHeadAvatars()).ownBodyAvatars(character.getOwnBodyAvatars()).build();
    }

    public static OwnEyesAvatar saveOwnEyesAvatarConverter(Member member, Eyes eyes){
        return OwnEyesAvatar.builder()
                .eyes(eyes)
                .character(member.getCharacter()).build();
    }
}
