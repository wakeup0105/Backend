package hackerton.wakeup.member.entity.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshRequestDTO {
    @NotBlank
    private String refreshToken;
}
