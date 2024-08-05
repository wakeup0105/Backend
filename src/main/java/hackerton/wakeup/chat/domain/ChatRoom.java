package hackerton.wakeup.chat.domain;

import hackerton.wakeup.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@EqualsAndHashCode(of = "id", callSuper = false)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ChatRoom extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String code;

    @Column
    private Integer memberNum = 1;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column
    private Status status = Status.open;

    @Column
    private String password;

    @Column
    private boolean isPublic;

    @ManyToOne
    @JoinColumn(name = "BACKGROUND_IMAGE")
    private Background background;
}
