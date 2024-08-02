package hackerton.wakeup.eyes.own.entity.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllOwnEyesResponseDTO {
    private Long id;
    private Long characterId;
    private String name;
    private int price;
}
