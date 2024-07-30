package hackerton.wakeup.eyes.own.service;

import hackerton.wakeup.character.entity.CharacterId;
import hackerton.wakeup.eyes.own.entity.dto.response.AllOwnEyesResponseDTO;

import java.util.List;

public interface OwnEyesAvatarService {
    List<AllOwnEyesResponseDTO> getAllOwnEyesAvatars(CharacterId id);
}
