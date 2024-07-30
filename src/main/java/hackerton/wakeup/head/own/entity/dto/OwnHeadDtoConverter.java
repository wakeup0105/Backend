package hackerton.wakeup.head.own.entity.dto;

import hackerton.wakeup.head.own.entity.OwnHeadAvatar;
import hackerton.wakeup.head.own.entity.dto.response.AllOwnHeadResponseDTO;

public class OwnHeadDtoConverter {

    public static AllOwnHeadResponseDTO allOwnHeadResponseConverter(OwnHeadAvatar res){
        AllOwnHeadResponseDTO dto = new AllOwnHeadResponseDTO();
        dto.setId(res.getId());
        dto.setCharacterId(res.getCharacter().getId().getId());
        dto.setName(res.getHead().getName());
        dto.setPrice(res.getHead().getPrice());
        return dto;
    }
}
