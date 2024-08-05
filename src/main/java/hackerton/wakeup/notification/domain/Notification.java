package hackerton.wakeup.notification.domain;

import hackerton.wakeup.common.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder(toBuilder = true)
@EqualsAndHashCode(of = "id", callSuper = false)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Notification extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime date;

    // 초 단위로 저장해서 비즈니스 로직 단계에서 변환
    @Column
    private Long time;

    @Column
    private Boolean isPersonal;
}
