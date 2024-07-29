package hackerton.wakeup.eyes.own.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hackerton.wakeup.character.entity.Character;
import hackerton.wakeup.eyes.part.entity.Eyes;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "OwnEyesAvatar")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OwnEyesAvatar {

    @EmbeddedId
    private OwnEyesAvatarId id;

    @JsonBackReference
    @MapsId("characterId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "character_id", referencedColumnName = "id"),
            @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    })
    private Character character;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eyes_id")
    private Eyes eyes;
}
