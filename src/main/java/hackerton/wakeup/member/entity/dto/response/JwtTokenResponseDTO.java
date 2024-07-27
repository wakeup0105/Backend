package hackerton.wakeup.member.entity.dto.response;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
public class JwtTokenResponseDTO {

    private String token_type = "Bearer ";

    @NotBlank
    private String access_token;

    @NotBlank
    private String expires_in;

    public JwtTokenResponseDTO(String access_token, String expires_in) {
        this.access_token = access_token;
        this.expires_in = expires_in;
    }
}
