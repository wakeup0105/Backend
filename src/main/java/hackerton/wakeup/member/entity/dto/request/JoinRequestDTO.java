package hackerton.wakeup.member.entity.dto.request;

import hackerton.wakeup.member.entity.Member;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class JoinRequestDTO {

    @NotBlank(message = "이메일이 비어있습니다.")
    private String email;

    @NotBlank(message = "비밀번호가 비어있습니다.")
    private String password;
    private String checkPassword;

    @NotBlank(message = "인증코드가 비어있습니다.")
    private String verificationCode;

    public Member toEntity(){
        return Member.builder()
                .email(this.email)
                .password(this.password)
                .point(300)
                .build();
    }
}
