package hackerton.wakeup.head.own.service;

import hackerton.wakeup.character.entity.CharacterId;
import hackerton.wakeup.head.own.entity.OwnHeadAvatar;
import hackerton.wakeup.head.own.entity.dto.OwnHeadDtoConverter;
import hackerton.wakeup.head.own.entity.dto.response.AllOwnHeadResponseDTO;
import hackerton.wakeup.head.own.entity.dto.response.BuyHeadResponseDTO;
import hackerton.wakeup.head.own.repository.OwnHeadAvatarRepository;
import hackerton.wakeup.head.part.entity.Head;
import hackerton.wakeup.head.part.repository.HeadRepository;
import hackerton.wakeup.member.entity.Member;
import hackerton.wakeup.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Primary
public class OwnHeadAvatarServiceImpl implements OwnHeadAvatarService {
    private final MemberRepository memberRepository;
    private final HeadRepository headRepository;
    private final OwnHeadAvatarRepository ownHeadAvatarRepository;

    @Override
    public List<AllOwnHeadResponseDTO> getAllOwnHeadAvatar(CharacterId id) {
        return ownHeadAvatarRepository.findAllByCharacterId(id).stream()
                .map(OwnHeadDtoConverter::allOwnHeadResponseConverter)
                .collect(Collectors.toList());
    }

    @Override
    public BuyHeadResponseDTO buyHead(Member member, String name) {
        Head findAvatar = headRepository.findByName(name);
        if (findAvatar == null || findAvatar.getPrice() > member.getPoint()) {
            return null;
        }
        memberRepository.save(Member.builder()
                .id(member.getId())
                .email(member.getEmail())
                .password(member.getPassword())
                .point(member.getPoint() - findAvatar.getPrice())
                .memberInfo(member.getMemberInfo())
                .character(member.getCharacter()).build());
        OwnHeadAvatar save = ownHeadAvatarRepository.save(OwnHeadDtoConverter.saveOwnHeadAvatar(member, findAvatar));
        return OwnHeadDtoConverter.buyHeadResponseConverter(save);
    }
}
