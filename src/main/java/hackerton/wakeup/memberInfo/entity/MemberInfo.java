package hackerton.wakeup.memberInfo.entity;

import hackerton.wakeup.member.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    private String nickname;

    private String tag;
}
