package hackerton.wakeup.eyes.own.service;

import hackerton.wakeup.character.entity.CharacterId;
import hackerton.wakeup.eyes.own.entity.OwnEyesAvatar;

import java.util.List;

public interface OwnEyesAvatarService {
    List<OwnEyesAvatar> getAllOwnEyesAvatars(CharacterId id);
    boolean isOwnEyesAvatarExists(Long eyes_id);
}
