package hackerton.wakeup.head.own.service;

import hackerton.wakeup.character.entity.CharacterId;
import hackerton.wakeup.head.own.entity.dto.response.AllOwnHeadResponseDTO;
import hackerton.wakeup.head.own.entity.dto.response.BuyHeadResponseDTO;
import hackerton.wakeup.member.entity.Member;

import java.util.List;

public interface OwnHeadAvatarService {
    List<AllOwnHeadResponseDTO> getAllOwnHeadAvatar(CharacterId id);
    BuyHeadResponseDTO buyHead(Member member, String name);
    boolean equipHeadAvatar(Member member, String name);
}
