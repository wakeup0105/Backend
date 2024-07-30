package hackerton.wakeup.eyes.own.entity.dto.response;

import hackerton.wakeup.character.entity.Character;
import hackerton.wakeup.eyes.part.entity.Eyes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllOwnEyesResponseDTO {
    private Long id;
    private Character character;
    private Eyes eyes;
}
