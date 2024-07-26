package hackerton.wakeup.character.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Character")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Character {
}
