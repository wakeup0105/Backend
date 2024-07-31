package hackerton.wakeup.mouth.own.entity.dto;

import hackerton.wakeup.mouth.own.entity.OwnMouthAvatar;
import hackerton.wakeup.mouth.own.entity.dto.response.AllOwnMouthResponseDTO;

public class OwnMouthDtoConverter {

    public static AllOwnMouthResponseDTO allOwnMouthResponseConverter(OwnMouthAvatar res){
        AllOwnMouthResponseDTO dto = new AllOwnMouthResponseDTO();
        dto.setId(res.getId());
        dto.setCharacterId(res.getCharacter().getId().getId());
        dto.setName(res.getMouth().getName());
        dto.setPrice(res.getMouth().getPrice());
        return dto;
    }
}
