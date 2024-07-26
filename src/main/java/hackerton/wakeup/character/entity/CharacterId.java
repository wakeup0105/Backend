package hackerton.wakeup.character.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CharacterId implements Serializable {
    private Long id;
    private Long member;
}
