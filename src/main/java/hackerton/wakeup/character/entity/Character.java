package hackerton.wakeup.character.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Character")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Character {

    @EmbeddedId
    private CharacterId id;
}
