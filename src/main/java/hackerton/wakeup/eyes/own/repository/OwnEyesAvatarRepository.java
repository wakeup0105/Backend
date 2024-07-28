package hackerton.wakeup.eyes.own.repository;

import hackerton.wakeup.eyes.own.entity.OwnEyesAvatar;
import hackerton.wakeup.eyes.own.entity.OwnEyesAvatarId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnEyesAvatarRepository extends JpaRepository<OwnEyesAvatar, OwnEyesAvatarId> {
}
