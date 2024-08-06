package hackerton.wakeup.body.own.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hackerton.wakeup.body.part.entity.Body;
import hackerton.wakeup.character.entity.Character;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "OwnBodyAvatar")
@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OwnBodyAvatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "body_id")
    private Body body;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "character", referencedColumnName = "id"),
            @JoinColumn(name = "member", referencedColumnName = "member_id")
    })
    private Character character;
}
