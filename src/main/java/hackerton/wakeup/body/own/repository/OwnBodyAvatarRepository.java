package hackerton.wakeup.body.own.repository;

import hackerton.wakeup.body.own.entity.OwnBodyAvatar;
import hackerton.wakeup.body.part.entity.Body;
import hackerton.wakeup.character.entity.CharacterId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnBodyAvatarRepository extends JpaRepository<OwnBodyAvatar, Long> {
    List<OwnBodyAvatar> findAllByCharacterId(CharacterId id);
    OwnBodyAvatar findOneByBody(Body body);
}
