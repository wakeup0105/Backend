package hackerton.wakeup.body.own.entity.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllOwnBodyResponseDTO {
    private Long id;
    private Long characterId;
    private String name;
    private int price;
}
