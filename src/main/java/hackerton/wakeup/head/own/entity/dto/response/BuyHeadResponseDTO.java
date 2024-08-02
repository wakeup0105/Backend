package hackerton.wakeup.head.own.entity.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuyHeadResponseDTO {
    private String nickname;
    private String avatarName;
    private int price;
    private int point;
}
