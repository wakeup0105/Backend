package hackerton.wakeup.member.entity.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindAccountRequestDTO {
    @NotBlank(message = "이메일이 비어있습니다.")
    private String email;

    @NotBlank(message = "인증번호가 비어있습니다.")
    private String verificationCode;
}
