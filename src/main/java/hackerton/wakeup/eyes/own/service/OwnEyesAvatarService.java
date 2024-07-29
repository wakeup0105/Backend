package hackerton.wakeup.eyes.own.service;

import hackerton.wakeup.eyes.own.entity.OwnEyesAvatar;
import hackerton.wakeup.eyes.own.entity.OwnEyesAvatarId;

import java.util.List;

public interface OwnEyesAvatarService {
    List<OwnEyesAvatar> getAllOwnEyesAvatars(OwnEyesAvatarId id);
}
