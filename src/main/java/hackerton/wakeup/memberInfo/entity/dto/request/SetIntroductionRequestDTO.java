package hackerton.wakeup.memberInfo.entity.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SetIntroductionRequestDTO {
    @NotBlank(message = "자기소개는 최소 한 글자 이상 입력해야합니다.")
    private String introduction;
}
