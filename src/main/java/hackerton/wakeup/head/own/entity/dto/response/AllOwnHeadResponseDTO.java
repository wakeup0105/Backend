package hackerton.wakeup.head.own.entity.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllOwnHeadResponseDTO {
    private Long id;
    private Long characterId;
    private String name;
    private String price;
}
