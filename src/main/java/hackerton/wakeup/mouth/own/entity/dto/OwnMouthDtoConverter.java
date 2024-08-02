package hackerton.wakeup.mouth.own.entity.dto;

import hackerton.wakeup.eyes.part.entity.Mouth;
import hackerton.wakeup.member.entity.Member;
import hackerton.wakeup.mouth.own.entity.OwnMouthAvatar;
import hackerton.wakeup.mouth.own.entity.dto.response.AllOwnMouthResponseDTO;
import hackerton.wakeup.mouth.own.entity.dto.response.BuyMouthResponseDTO;

public class OwnMouthDtoConverter {

    public static AllOwnMouthResponseDTO allOwnMouthResponseConverter(OwnMouthAvatar res){
        AllOwnMouthResponseDTO dto = new AllOwnMouthResponseDTO();
        dto.setId(res.getId());
        dto.setCharacterId(res.getCharacter().getId().getId());
        dto.setName(res.getMouth().getName());
        dto.setPrice(res.getMouth().getPrice());
        return dto;
    }

    public static BuyMouthResponseDTO buyMouthResponseConverter(OwnMouthAvatar res){
        BuyMouthResponseDTO dto = new BuyMouthResponseDTO();
        dto.setNickname(res.getCharacter().getMember().getMemberInfo().getNickname() + "#"
                + res.getCharacter().getMember().getMemberInfo().getTag());
        dto.setAvatarName(res.getMouth().getName());
        dto.setPrice(res.getMouth().getPrice());
        dto.setPoint(res.getCharacter().getMember().getPoint());

        return dto;
    }

    public static OwnMouthAvatar saveOwnMouthAvatar(Member member, Mouth mouth){
        return OwnMouthAvatar.builder()
                .mouth(mouth)
                .character(member.getCharacter()).build();
    }
}
