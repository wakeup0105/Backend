package hackerton.wakeup.character.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import hackerton.wakeup.member.entity.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "Character")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Character {

    @EmbeddedId
    private CharacterId id;

    @JsonBackReference
    @MapsId("member")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @NotNull
    private int level;
}
