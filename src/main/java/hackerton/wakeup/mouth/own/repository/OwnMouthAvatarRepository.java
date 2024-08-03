package hackerton.wakeup.mouth.own.repository;

import hackerton.wakeup.character.entity.CharacterId;
import hackerton.wakeup.eyes.part.entity.Mouth;
import hackerton.wakeup.mouth.own.entity.OwnMouthAvatar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnMouthAvatarRepository extends JpaRepository<OwnMouthAvatar, Long> {
    List<OwnMouthAvatar> findAllByCharacterId(CharacterId id);
    OwnMouthAvatar findOneByMouth(Mouth mouth);
}
