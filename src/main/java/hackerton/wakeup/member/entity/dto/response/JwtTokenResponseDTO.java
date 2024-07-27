package hackerton.wakeup.member.entity.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtTokenResponseDTO {

    @NotBlank
    private String access_token;

    @NotBlank
    private String expires_in;
}
