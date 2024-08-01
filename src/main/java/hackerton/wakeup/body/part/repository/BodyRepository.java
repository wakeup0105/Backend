package hackerton.wakeup.body.part.repository;

import hackerton.wakeup.body.part.entity.Body;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BodyRepository extends JpaRepository<Body, Long> {
    Body findByName(String name);
}
