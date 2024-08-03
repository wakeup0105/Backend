package hackerton.wakeup.mouth.own.service;

import hackerton.wakeup.character.entity.CharacterId;
import hackerton.wakeup.member.entity.Member;
import hackerton.wakeup.mouth.own.entity.dto.response.AllOwnMouthResponseDTO;
import hackerton.wakeup.mouth.own.entity.dto.response.BuyMouthResponseDTO;

import java.util.List;

public interface OwnMouthAvatarService {
    List<AllOwnMouthResponseDTO> getAllOwnMouthsAvatar(CharacterId id);
    BuyMouthResponseDTO buyMouth(Member member, String name);
    boolean equipMouthAvatar(Member member, String name);
}
