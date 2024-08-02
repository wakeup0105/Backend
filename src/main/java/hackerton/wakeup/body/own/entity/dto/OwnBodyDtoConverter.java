package hackerton.wakeup.body.own.entity.dto;

import hackerton.wakeup.body.own.entity.OwnBodyAvatar;
import hackerton.wakeup.body.own.entity.dto.response.AllOwnBodyResponseDTO;
import hackerton.wakeup.body.own.entity.dto.response.BuyBodyResponseDTO;
import hackerton.wakeup.body.part.entity.Body;
import hackerton.wakeup.character.entity.Character;
import hackerton.wakeup.member.entity.Member;

public class OwnBodyDtoConverter {

    public static AllOwnBodyResponseDTO allOwnBodyResponseConverter(OwnBodyAvatar res){
        AllOwnBodyResponseDTO dto = new AllOwnBodyResponseDTO();
        dto.setId(res.getId());
        dto.setCharacterId(res.getCharacter().getId().getId());
        dto.setName(res.getBody().getName());
        dto.setPrice(res.getBody().getPrice());
        return dto;
    }

    public static BuyBodyResponseDTO buyBodyResponseConverter(OwnBodyAvatar res){
        BuyBodyResponseDTO dto = new BuyBodyResponseDTO();
        dto.setNickname(res.getCharacter().getMember().getMemberInfo().getNickname() + "#"
                + res.getCharacter().getMember().getMemberInfo().getTag());
        dto.setAvatarName(res.getBody().getName());
        dto.setPrice(res.getBody().getPrice());
        dto.setPoint(res.getCharacter().getMember().getPoint());
        return dto;
    }

    public static Character equipBodyConverter(Character character, String name){
        return Character.builder()
                .id(character.getId())
                .member(character.getMember())
                .level(character.getLevel())
                .exp(character.getExp())
                .eyes(character.getEyes()).mouth(character.getMouth()).head(character.getHead()).body(name)
                .ownEyesAvatars(character.getOwnEyesAvatars()).ownMouthAvatars(character.getOwnMouthAvatars())
                .ownHeadAvatars(character.getOwnHeadAvatars()).ownBodyAvatars(character.getOwnBodyAvatars()).build();
    }

    public static OwnBodyAvatar saveOwnBodyAvatar(Member member, Body body){
        return OwnBodyAvatar.builder()
                .body(body)
                .character(member.getCharacter()).build();
    }
}
