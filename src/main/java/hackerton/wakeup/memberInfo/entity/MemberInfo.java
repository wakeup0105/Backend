package hackerton.wakeup.memberInfo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import hackerton.wakeup.member.entity.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "MemberInfo")
@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MemberInfo {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private MemberInfoId id;

    @JsonBackReference
    @MapsId("member")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Size(min = 2, max = 30)
    @NotBlank
    private String nickname;

    @NotBlank
    private String tag;

    private String introduction;
}
