package hackerton.wakeup.mouth.own.service;

import hackerton.wakeup.character.entity.CharacterId;
import hackerton.wakeup.mouth.own.entity.dto.response.AllOwnMouthResponseDTO;

import java.util.List;

public interface OwnMouthAvatarService {
    List<AllOwnMouthResponseDTO> getAllOwnMouthsAvatar(CharacterId id);
    boolean isOwnMouthAvatarExists(String name);
}
