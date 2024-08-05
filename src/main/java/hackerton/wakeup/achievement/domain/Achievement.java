package hackerton.wakeup.achievement.domain;

import hackerton.wakeup.common.domain.BaseEntity;
import hackerton.wakeup.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@EqualsAndHashCode(of = "id", callSuper = false)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Achievement extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer success;

    @Column
    private Integer failure;

    // yyMMdd(ex-240101)
    @Column
    private String date;

    @OneToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
}
