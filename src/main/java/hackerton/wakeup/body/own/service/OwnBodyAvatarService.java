package hackerton.wakeup.body.own.service;

import hackerton.wakeup.body.own.entity.dto.response.AllOwnBodyResponseDTO;
import hackerton.wakeup.character.entity.CharacterId;

import java.util.List;

public interface OwnBodyAvatarService {
    List<AllOwnBodyResponseDTO> getAllOwnBodyAvatars(CharacterId id);
}