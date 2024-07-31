package hackerton.wakeup.body.part.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import hackerton.wakeup.body.own.entity.OwnBodyAvatar;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Body")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Body {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private String price;

    @JsonManagedReference
    @OneToMany(mappedBy = "body", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OwnBodyAvatar> ownBodyAvatars;
}
