package hackerton.wakeup.head.own.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hackerton.wakeup.character.entity.Character;
import hackerton.wakeup.head.part.entity.Head;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "OwnHeadAvatar")
@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OwnHeadAvatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "head_id")
    private Head head;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "character", referencedColumnName = "id"),
            @JoinColumn(name = "member", referencedColumnName = "member_id")
    })
    private Character character;
}
