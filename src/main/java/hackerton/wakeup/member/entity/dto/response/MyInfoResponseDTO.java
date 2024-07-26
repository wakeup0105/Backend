package hackerton.wakeup.member.entity.dto.response;

import hackerton.wakeup.member.entity.Member;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MyInfoResponseDTO {
    @NotBlank
    private String email;

    @NotBlank
    private String code;

    public MyInfoResponseDTO toEntity(String email, String code) {
        MyInfoResponseDTO myInfoResponseDTO = new MyInfoResponseDTO();
        myInfoResponseDTO.setEmail(email);
        myInfoResponseDTO.setCode(code);
        return myInfoResponseDTO;
    }
}
