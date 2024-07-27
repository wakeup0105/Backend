package hackerton.wakeup.character.repository;

import hackerton.wakeup.character.entity.Character;
import hackerton.wakeup.character.entity.CharacterId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Character, CharacterId> {
    Optional<Character> findByIdMember(Long member);
}
