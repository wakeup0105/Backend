package hackerton.wakeup.head.part.repository;

import hackerton.wakeup.head.part.entity.Head;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeadRepository extends JpaRepository<Head, Long> {
    Head findByName(String name);
}
