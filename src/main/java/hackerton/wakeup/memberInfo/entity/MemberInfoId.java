package hackerton.wakeup.memberInfo.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

import java.io.Serializable;

@Data
@Builder(toBuilder = true)
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MemberInfoId implements Serializable {
    private Long id;
    private Long member;
}
