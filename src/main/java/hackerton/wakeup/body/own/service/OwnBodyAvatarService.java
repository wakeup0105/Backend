package hackerton.wakeup.body.own.service;

import hackerton.wakeup.body.own.entity.dto.response.AllOwnBodyResponseDTO;
import hackerton.wakeup.body.own.entity.dto.response.BuyBodyResponseDTO;
import hackerton.wakeup.character.entity.CharacterId;
import hackerton.wakeup.member.entity.Member;

import java.util.List;

public interface OwnBodyAvatarService {
    List<AllOwnBodyResponseDTO> getAllOwnBodyAvatars(CharacterId id);
    BuyBodyResponseDTO buyBody(Member member, String name);
    boolean equipBodyAvatar(Member member, String name);
}
