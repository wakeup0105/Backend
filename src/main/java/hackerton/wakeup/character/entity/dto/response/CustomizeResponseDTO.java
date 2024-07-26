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

    public static CustomizeResponseDTO fromEntity(Character character){
        CustomizeResponseDTO dto = new CustomizeResponseDTO();
        dto.setEyes(character.getEyes());
        dto.setMouth(character.getMouth());
        dto.setHead(character.getHead());
        dto.setBody(character.getBody());
        return dto;
    }
}
