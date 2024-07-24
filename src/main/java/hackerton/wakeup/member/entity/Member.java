package hackerton.wakeup.member.entity;

import hackerton.wakeup.memberInfo.entity.MemberInfo;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "Member")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @Column(nullable = false, unique = true)
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotNull
    @Min(0)
    private int point;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MemberInfo memberInfo;
}
