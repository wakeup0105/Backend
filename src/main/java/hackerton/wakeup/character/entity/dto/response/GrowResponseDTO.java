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

    public GrowResponseDTO toEntity(Character character){
        GrowResponseDTO growResponseDTO = new GrowResponseDTO();
        growResponseDTO.setLevel(character.getLevel());
        growResponseDTO.setExp(character.getExp());
        return growResponseDTO;
    }
}
