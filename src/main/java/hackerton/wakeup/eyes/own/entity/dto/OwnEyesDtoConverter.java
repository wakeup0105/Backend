package hackerton.wakeup.eyes.own.entity.dto;

import hackerton.wakeup.eyes.own.entity.OwnEyesAvatar;
import hackerton.wakeup.eyes.own.entity.dto.response.AllOwnEyesResponseDTO;

public class OwnEyesDtoConverter {

    public static AllOwnEyesResponseDTO allOwnEyesResponseConverter(OwnEyesAvatar res){
        AllOwnEyesResponseDTO dto = new AllOwnEyesResponseDTO();
        dto.setId(res.getId());
        dto.setCharacterId(res.getCharacter().getId().getId());
        dto.setName(res.getEyes().getName());
        dto.setPrice(res.getEyes().getPrice());
        return dto;
    }
}
