package hackerton.wakeup.eyes.own.entity.dto;

import hackerton.wakeup.eyes.own.entity.OwnEyesAvatar;
import hackerton.wakeup.eyes.own.entity.dto.response.AllOwnEyesResponseDTO;
import hackerton.wakeup.eyes.own.entity.dto.response.BuyEyesResponseDTO;

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
    }
}
