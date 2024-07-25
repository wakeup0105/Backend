package hackerton.wakeup.memberInfo.entity;

import hackerton.wakeup.member.entity.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "MemberInfo")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberInfo {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private MemberInfoId id;

    @MapsId("member")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Size(min = 2, max = 30)
    @NotBlank
    private String nickname;

    @NotBlank
    private String tag;
}
