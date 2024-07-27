package hackerton.wakeup.eyes.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class OwnEyesAvatarId implements Serializable {
    private Long eyes_id;
    private Long character_id;
}
