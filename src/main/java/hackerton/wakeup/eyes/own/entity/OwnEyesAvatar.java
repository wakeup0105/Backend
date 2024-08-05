package hackerton.wakeup.eyes.own.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hackerton.wakeup.character.entity.Character;
import hackerton.wakeup.eyes.part.entity.Eyes;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "OwnEyesAvatar")
@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OwnEyesAvatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eyes_id")
    private Eyes eyes;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "character", referencedColumnName = "id"),
            @JoinColumn(name = "member", referencedColumnName = "member_id")
    })
    private Character character;
}
