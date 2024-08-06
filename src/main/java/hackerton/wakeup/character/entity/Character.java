package hackerton.wakeup.character.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import hackerton.wakeup.body.own.entity.OwnBodyAvatar;
import hackerton.wakeup.eyes.own.entity.OwnEyesAvatar;
import hackerton.wakeup.head.own.entity.OwnHeadAvatar;
import hackerton.wakeup.member.entity.Member;
import hackerton.wakeup.mouth.own.entity.OwnMouthAvatar;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Character")
@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OwnEyesAvatar> ownEyesAvatars;

    @JsonManagedReference
    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OwnMouthAvatar> ownMouthAvatars;

    @JsonManagedReference
    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OwnHeadAvatar> ownHeadAvatars;

    @JsonManagedReference
    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OwnBodyAvatar> ownBodyAvatars;
}
