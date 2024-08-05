package hackerton.wakeup.member.entity.dto.request;

import jakarta.validation.constraints.NotBlank;

public class RefreshRequestDTO {
    @NotBlank
    private String refreshToken;
}
