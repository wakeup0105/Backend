package hackerton.wakeup.eyes.own.service;

import hackerton.wakeup.character.entity.CharacterId;
import hackerton.wakeup.eyes.own.entity.OwnEyesAvatar;
import hackerton.wakeup.eyes.own.entity.dto.OwnEyesDtoConverter;
import hackerton.wakeup.eyes.own.entity.dto.response.AllOwnEyesResponseDTO;
import hackerton.wakeup.eyes.own.entity.dto.response.BuyEyesResponseDTO;
import hackerton.wakeup.eyes.own.repository.OwnEyesAvatarRepository;
import hackerton.wakeup.eyes.part.entity.Eyes;
import hackerton.wakeup.eyes.part.repository.EyesRepository;
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
public class OwnEyesAvatarServiceImpl implements OwnEyesAvatarService {

    private final MemberRepository memberRepository;
    private final OwnEyesAvatarRepository ownEyesAvatarRepository;
    private final EyesRepository eyesRepository;

    @Override
    public List<AllOwnEyesResponseDTO> getAllOwnEyesAvatars(CharacterId id) {
        return ownEyesAvatarRepository.findAllByCharacterId(id).stream()
                .map(OwnEyesDtoConverter::allOwnEyesResponseConverter)
                .collect(Collectors.toList());
    }

    @Override
    public BuyEyesResponseDTO buyEyes(Member member, String name) {
        Eyes findAvatar = eyesRepository.findByName(name);
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
        OwnEyesAvatar save = ownEyesAvatarRepository.save(OwnEyesDtoConverter.saveOwnEyesAvatar(member, findAvatar));
        return OwnEyesDtoConverter.buyEyesResponseConverter(save);
    }
}
