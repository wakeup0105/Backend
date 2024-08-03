package hackerton.wakeup.mouth.part.repository;

import hackerton.wakeup.eyes.part.entity.Mouth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MouthRepository extends JpaRepository<Mouth, Long> {
    Mouth findByName(String name);
}
