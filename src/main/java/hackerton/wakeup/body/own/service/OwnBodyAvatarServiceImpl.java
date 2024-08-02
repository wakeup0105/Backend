package hackerton.wakeup.body.own.service;

import hackerton.wakeup.body.own.entity.OwnBodyAvatar;
import hackerton.wakeup.body.own.entity.dto.OwnBodyDtoConverter;
import hackerton.wakeup.body.own.entity.dto.response.AllOwnBodyResponseDTO;
import hackerton.wakeup.body.own.entity.dto.response.BuyBodyResponseDTO;
import hackerton.wakeup.body.own.repository.OwnBodyAvatarRepository;
import hackerton.wakeup.body.part.entity.Body;
import hackerton.wakeup.body.part.repository.BodyRepository;
import hackerton.wakeup.character.entity.Character;
import hackerton.wakeup.character.entity.CharacterId;
import hackerton.wakeup.character.repository.CharacterRepository;
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
public class OwnBodyAvatarServiceImpl implements OwnBodyAvatarService {
    private final MemberRepository memberRepository;
    private final BodyRepository bodyRepository;
    private final CharacterRepository characterRepository;
    private final OwnBodyAvatarRepository ownBodyAvatarRepository;

    @Override
    public List<AllOwnBodyResponseDTO> getAllOwnBodyAvatars(CharacterId id) {
        return ownBodyAvatarRepository.findAllByCharacterId(id).stream()
                .map(OwnBodyDtoConverter::allOwnBodyResponseConverter)
                .collect(Collectors.toList());
    }

    @Override
    public BuyBodyResponseDTO buyBody(Member member, String name) {
        Body findAvatar = bodyRepository.findByName(name);
        OwnBodyAvatar oneByBody = ownBodyAvatarRepository.findOneByBody(findAvatar);
        if (findAvatar == null || oneByBody != null) return null;
        if (findAvatar.getPrice() > member.getPoint()) return null;
        memberRepository.save(Member.builder()
                .id(member.getId())
                .email(member.getEmail())
                .password(member.getPassword())
                .point(member.getPoint() - findAvatar.getPrice())
                .memberInfo(member.getMemberInfo())
                .character(member.getCharacter()).build());
        OwnBodyAvatar save = ownBodyAvatarRepository.save(OwnBodyDtoConverter.saveOwnBodyAvatar(member, findAvatar));
        return OwnBodyDtoConverter.buyBodyResponseConverter(save);
    }

    @Override
    public boolean equipBodyAvatar(Member member, String name) {
        Body findAvatar = bodyRepository.findByName(name);
        OwnBodyAvatar oneByBody = ownBodyAvatarRepository.findOneByBody(findAvatar);
        if (findAvatar == null || oneByBody == null) return false;
        Character character = member.getCharacter();
        characterRepository.save(OwnBodyDtoConverter.equipBodyConverter(character, name));
        return true;
    }
}
