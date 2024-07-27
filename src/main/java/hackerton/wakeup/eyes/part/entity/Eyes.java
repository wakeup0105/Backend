package hackerton.wakeup.eyes.part.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Eyes")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Eyes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
