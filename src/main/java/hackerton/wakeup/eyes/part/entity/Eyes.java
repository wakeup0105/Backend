package hackerton.wakeup.eyes.part.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank
    private String name;

    @NotNull
    private String price;
}
