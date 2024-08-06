package hackerton.wakeup.head.part.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import hackerton.wakeup.head.own.entity.OwnHeadAvatar;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Head")
@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Head {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private int price;

    @JsonManagedReference
    @OneToMany(mappedBy = "head", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OwnHeadAvatar> ownheadAvatars;
}
