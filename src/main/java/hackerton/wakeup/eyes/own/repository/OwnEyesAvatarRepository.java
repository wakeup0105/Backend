package hackerton.wakeup.eyes.own.repository;

import hackerton.wakeup.character.entity.CharacterId;
import hackerton.wakeup.eyes.own.entity.OwnEyesAvatar;
import hackerton.wakeup.eyes.own.entity.OwnEyesAvatarId;
import hackerton.wakeup.eyes.part.entity.Eyes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnEyesAvatarRepository extends JpaRepository<OwnEyesAvatar, OwnEyesAvatarId> {
    List<OwnEyesAvatar> findAllById(CharacterId id);
    boolean existsByEyes(Eyes eye);
}
