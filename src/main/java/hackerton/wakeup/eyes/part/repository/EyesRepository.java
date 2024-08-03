package hackerton.wakeup.eyes.part.repository;

import hackerton.wakeup.eyes.part.entity.Eyes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EyesRepository extends JpaRepository<Eyes, Long> {
    Eyes findByName(String name);
}
