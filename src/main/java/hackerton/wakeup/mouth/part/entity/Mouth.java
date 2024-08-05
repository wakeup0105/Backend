package hackerton.wakeup.eyes.part.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import hackerton.wakeup.eyes.own.entity.OwnEyesAvatar;
import hackerton.wakeup.mouth.own.entity.OwnMouthAvatar;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "mouth")
@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mouth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private int price;

    @JsonManagedReference
    @OneToMany(mappedBy = "mouth", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OwnMouthAvatar> ownMouthAvatars;
}
