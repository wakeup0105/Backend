package hackerton.wakeup.memberInfo.entity;

import hackerton.wakeup.member.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MemberInfo")
@IdClass(MemberInfo.class)
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String nickname;

    private String tag;
}
