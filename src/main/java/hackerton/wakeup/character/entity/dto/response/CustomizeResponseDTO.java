package hackerton.wakeup.character.entity.dto.response;

import hackerton.wakeup.character.entity.Character;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class CustomizeResponseDTO {
    private String eyes;
    private String mouth;
    private String head;
    private String body;

    public CustomizeResponseDTO toEntity(Character character){
        CustomizeResponseDTO customizeResponseDTO = new CustomizeResponseDTO();
        customizeResponseDTO.setEyes(character.getEyes());
        customizeResponseDTO.setMouth(character.getMouth());
        customizeResponseDTO.setHead(character.getHead());
        customizeResponseDTO.setBody(character.getBody());
        return customizeResponseDTO;
    }
}
