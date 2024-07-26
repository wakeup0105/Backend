package hackerton.wakeup.character.entity.dto.response;

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
}
