package hackerton.wakeup.refresh.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "RefreshToken")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RefreshToken {
}
