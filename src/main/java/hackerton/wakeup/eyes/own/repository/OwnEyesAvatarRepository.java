package hackerton.wakeup.eyes.own.repository;

import hackerton.wakeup.character.entity.CharacterId;
import hackerton.wakeup.eyes.own.entity.OwnEyesAvatar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnEyesAvatarRepository extends JpaRepository<OwnEyesAvatar, Long> {
    List<OwnEyesAvatar> findAllByCharacterId(CharacterId id);
}
