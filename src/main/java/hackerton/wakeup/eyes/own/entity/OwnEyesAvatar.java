package hackerton.wakeup.eyes.own.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hackerton.wakeup.eyes.part.entity.Eyes;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "OwnEyesTable")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OwnEyesAvatar {

    @EmbeddedId
    private OwnEyesAvatarId id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eyes_id")
    private Eyes eyes;
}
