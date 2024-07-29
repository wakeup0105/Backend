package hackerton.wakeup.eyes.own.repository;

import hackerton.wakeup.eyes.own.entity.OwnEyesAvatar;
import hackerton.wakeup.eyes.own.entity.OwnEyesAvatarId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnEyesAvatarRepository extends JpaRepository<OwnEyesAvatar, OwnEyesAvatarId> {
    List<OwnEyesAvatar> findAllById(OwnEyesAvatarId id);
    boolean existsByEyes(Long eyes_id);
}
