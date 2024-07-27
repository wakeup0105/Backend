package hackerton.wakeup.eyes.own.entity;

import hackerton.wakeup.character.entity.CharacterId;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class OwnEyesAvatarId implements Serializable {
    private CharacterId characterId;
}
