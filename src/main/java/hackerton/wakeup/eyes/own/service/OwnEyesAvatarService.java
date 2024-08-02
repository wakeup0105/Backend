package hackerton.wakeup.eyes.own.service;

import hackerton.wakeup.character.entity.CharacterId;
import hackerton.wakeup.eyes.own.entity.OwnEyesAvatar;
import hackerton.wakeup.eyes.own.entity.dto.response.AllOwnEyesResponseDTO;
import hackerton.wakeup.eyes.own.entity.dto.response.BuyEyesResponseDTO;
import hackerton.wakeup.member.entity.Member;

import java.util.List;

public interface OwnEyesAvatarService {
    List<AllOwnEyesResponseDTO> getAllOwnEyesAvatars(CharacterId id);
    BuyEyesResponseDTO buyEyes(Member member, String name);
}
