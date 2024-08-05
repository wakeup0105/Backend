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

    @NotBlank
    private String refresh_token;

    @NotBlank
    private String refresh_expires_in;

    public JwtTokenResponseDTO(String access_token, String expires_in, String refresh_token, String refresh_expires_in) {
        this.access_token = access_token;
        this.expires_in = expires_in;
        this.refresh_token = refresh_token;
        this.refresh_expires_in = refresh_expires_in;
    }
}
