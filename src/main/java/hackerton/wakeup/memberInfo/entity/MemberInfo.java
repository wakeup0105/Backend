package hackerton.wakeup.memberInfo.entity;

import jakarta.persistence.*;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
}
