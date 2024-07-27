package hackerton.wakeup.member.entity.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class JwtTokenResponseDTO {

    @NotBlank
    private String access_token;
}
