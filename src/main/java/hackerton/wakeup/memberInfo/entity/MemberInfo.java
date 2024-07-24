package hackerton.wakeup.memberInfo.entity;

import hackerton.wakeup.member.entity.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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

    @Max(30)
    @Min(2)
    @NotBlank
    private String nickname;

    @NotBlank
    private String tag;
}
