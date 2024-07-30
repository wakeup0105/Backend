package hackerton.wakeup.character.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import hackerton.wakeup.eyes.own.entity.OwnEyesAvatar;
import hackerton.wakeup.member.entity.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

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

    @NotNull
    private Long exp;

    private String eyes;
    private String mouth;
    private String head;
    private String body;

    @JsonManagedReference
    @OneToMany(mappedBy = "characterMemberId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OwnEyesAvatar> ownEyesAvatars;
}
