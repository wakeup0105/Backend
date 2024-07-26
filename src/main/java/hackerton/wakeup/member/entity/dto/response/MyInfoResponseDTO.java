package hackerton.wakeup.member.entity.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyInfoResponseDTO {
    @NotBlank
    private String email;
}
