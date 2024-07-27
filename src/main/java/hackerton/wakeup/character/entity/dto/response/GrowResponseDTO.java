package hackerton.wakeup.character.entity.dto.response;

import hackerton.wakeup.character.entity.Character;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class GrowResponseDTO {
    @NotNull
    private int level;

    @NotNull
    private Long exp;

    public static GrowResponseDTO fromEntity(Character character){
        GrowResponseDTO dto = new GrowResponseDTO();
        dto.setLevel(character.getLevel());
        dto.setExp(character.getExp());
        return dto;
    }
}
