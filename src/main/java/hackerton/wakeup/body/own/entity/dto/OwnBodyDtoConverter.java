package hackerton.wakeup.body.own.entity.dto;

import hackerton.wakeup.body.own.entity.OwnBodyAvatar;
import hackerton.wakeup.body.own.entity.dto.response.AllOwnBodyResponseDTO;

public class OwnBodyDtoConverter {

    public static AllOwnBodyResponseDTO allOwnBodyResponseConverter(OwnBodyAvatar res){
        AllOwnBodyResponseDTO dto = new AllOwnBodyResponseDTO();
        dto.setId(res.getId());
        dto.setCharacterId(res.getCharacter().getId().getId());
        dto.setName(res.getBody().getName());
        dto.setPrice(res.getBody().getPrice());
        return dto;
    }
}
