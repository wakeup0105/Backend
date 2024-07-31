package hackerton.wakeup.head.own.service;

import hackerton.wakeup.character.entity.CharacterId;
import hackerton.wakeup.head.own.entity.dto.response.AllOwnHeadResponseDTO;

import java.util.List;

public interface OwnHeadAvatarService {
    List<AllOwnHeadResponseDTO> getAllOwnHeadAvatar(CharacterId id);
}
