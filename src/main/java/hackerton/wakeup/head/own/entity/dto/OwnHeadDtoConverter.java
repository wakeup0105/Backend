package hackerton.wakeup.head.own.entity.dto;

import hackerton.wakeup.character.entity.Character;
import hackerton.wakeup.head.own.entity.OwnHeadAvatar;
import hackerton.wakeup.head.own.entity.dto.response.AllOwnHeadResponseDTO;
import hackerton.wakeup.head.own.entity.dto.response.BuyHeadResponseDTO;
import hackerton.wakeup.head.part.entity.Head;
import hackerton.wakeup.member.entity.Member;

public class OwnHeadDtoConverter {

    public static AllOwnHeadResponseDTO allOwnHeadResponseConverter(OwnHeadAvatar res){
        AllOwnHeadResponseDTO dto = new AllOwnHeadResponseDTO();
        dto.setId(res.getId());
        dto.setCharacterId(res.getCharacter().getId().getId());
        dto.setName(res.getHead().getName());
        dto.setPrice(res.getHead().getPrice());
        return dto;
    }

    public static BuyHeadResponseDTO buyHeadResponseConverter(OwnHeadAvatar res){
        BuyHeadResponseDTO dto = new BuyHeadResponseDTO();
        dto.setNickname(res.getCharacter().getMember().getMemberInfo().getNickname() + "#"
                + res.getCharacter().getMember().getMemberInfo().getTag());
        dto.setAvatarName(res.getHead().getName());
        dto.setPrice(res.getHead().getPrice());
        dto.setPoint(res.getCharacter().getMember().getPoint());
        return dto;
    }

    public static Character equipHeadConverter(Character character, String name){
        return Character.builder()
                .id(character.getId())
                .member(character.getMember())
                .level(character.getLevel())
                .exp(character.getExp())
                .eyes(character.getEyes()).mouth(character.getMouth()).head(name).body(character.getBody())
                .ownEyesAvatars(character.getOwnEyesAvatars()).ownMouthAvatars(character.getOwnMouthAvatars())
                .ownHeadAvatars(character.getOwnHeadAvatars()).ownBodyAvatars(character.getOwnBodyAvatars()).build();
    }

    public static OwnHeadAvatar saveOwnHeadAvatarConverter(Member member, Head head){
        return OwnHeadAvatar.builder()
                .head(head)
                .character(member.getCharacter()).build();
    }
}
