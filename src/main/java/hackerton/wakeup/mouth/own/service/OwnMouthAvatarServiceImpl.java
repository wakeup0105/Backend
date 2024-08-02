package hackerton.wakeup.mouth.own.service;

import hackerton.wakeup.character.entity.CharacterId;
import hackerton.wakeup.eyes.part.entity.Mouth;
import hackerton.wakeup.member.entity.Member;
import hackerton.wakeup.member.repository.MemberRepository;
import hackerton.wakeup.mouth.own.entity.OwnMouthAvatar;
import hackerton.wakeup.mouth.own.entity.dto.OwnMouthDtoConverter;
import hackerton.wakeup.mouth.own.entity.dto.response.AllOwnMouthResponseDTO;
import hackerton.wakeup.mouth.own.entity.dto.response.BuyMouthResponseDTO;
import hackerton.wakeup.mouth.own.repository.OwnMouthAvatarRepository;
import hackerton.wakeup.mouth.part.repository.MouthRepository;
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
public class OwnMouthAvatarServiceImpl implements OwnMouthAvatarService {
    private final MemberRepository memberRepository;
    private final MouthRepository mouthRepository;
    private final OwnMouthAvatarRepository ownMouthAvatarRepository;

    @Override
    public List<AllOwnMouthResponseDTO> getAllOwnMouthsAvatar(CharacterId id) {
        return ownMouthAvatarRepository.findAllByCharacterId(id).stream()
                .map(OwnMouthDtoConverter::allOwnMouthResponseConverter)
                .collect(Collectors.toList());
    }

    @Override
    public BuyMouthResponseDTO buyMouth(Member member, String name) {
        Mouth findAvatar = mouthRepository.findByName(name);
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
        OwnMouthAvatar save = ownMouthAvatarRepository.save(OwnMouthDtoConverter.saveOwnMouthAvatar(member, findAvatar));
        return OwnMouthDtoConverter.buyMouthResponseConverter(save);
    }
}
