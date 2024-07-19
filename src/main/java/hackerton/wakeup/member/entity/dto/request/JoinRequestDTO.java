package hackerton.wakeup.member.entity.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class JoinRequestDTO {
    @NotBlank(message = "이메일이 비어있습니다.")
    private String email;
}
