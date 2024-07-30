package hackerton.wakeup.mouth.own.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hackerton.wakeup.character.entity.Character;
import hackerton.wakeup.mouth.part.entity.Mouth;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "OwnMouthAvatar")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OwnMouthAvatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mouth_id")
    private Mouth mouth;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "character", referencedColumnName = "id"),
            @JoinColumn(name = "member", referencedColumnName = "member_id")
    })
    private Character character;
}
