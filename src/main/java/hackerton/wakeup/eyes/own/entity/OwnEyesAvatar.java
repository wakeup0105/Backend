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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @MapsId("eyesId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eyes_id")
    private Eyes eyes;

    @JsonBackReference
    @MapsId("memberId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member", referencedColumnName = "member_id")
    private Character characterMemberId;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id", referencedColumnName = "id")
    private Character characterId;
}
