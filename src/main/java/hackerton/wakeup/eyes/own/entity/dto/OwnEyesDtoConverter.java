package hackerton.wakeup.eyes.own.entity.dto;

import hackerton.wakeup.eyes.own.entity.OwnEyesAvatar;
import hackerton.wakeup.eyes.own.entity.dto.response.AllOwnEyesResponseDTO;

public class OwnEyesDtoConverter {

    public static AllOwnEyesResponseDTO allOwnEyesResponseConverter(OwnEyesAvatar res){
        AllOwnEyesResponseDTO dto = new AllOwnEyesResponseDTO();
        dto.setId(res.getId());
        dto.setCharacter(res.getCharacter());
        dto.setEyes(res.getEyes());
        return dto;
    }
}
