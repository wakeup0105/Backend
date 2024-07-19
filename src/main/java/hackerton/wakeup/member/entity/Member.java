package hackerton.wakeup.member.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private Long pk;

    @Email
    @Column(nullable = false, unique = true)
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private int point;
}
