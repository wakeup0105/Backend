package hackerton.wakeup.character.repository;

import hackerton.wakeup.character.entity.CharacterId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, CharacterId> {
}
