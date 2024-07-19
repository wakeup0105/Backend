package hackerton.wakeup.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Member")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
}
