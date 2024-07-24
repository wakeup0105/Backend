package hackerton.wakeup.memberInfo.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MemberInfoId implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long member;
}
