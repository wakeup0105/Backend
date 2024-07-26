package hackerton.wakeup.character.service;

import hackerton.wakeup.character.entity.Character;
import hackerton.wakeup.character.entity.CharacterId;
import hackerton.wakeup.character.repository.CharacterRepository;
import hackerton.wakeup.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Primary
public class CharacterServiceImpl implements CharacterService {
    private final CharacterRepository characterRepository;

    @Override
    public Character initCharacter(Member member) {
        CharacterId buildId = CharacterId.builder().id(member.getId()).member(member.getId()).build();
        Character character = Character.builder().id(buildId).member(member).level(1).exp(0L).build();
        characterRepository.save(character);
        return characterRepository.findByIdMember(member.getId()).orElse(null);
    }

    @Override
    public Character getByMemberId(Long member_id) {
        Optional<Character> findMember = characterRepository.findByIdMember(member_id);
        return findMember.orElse(null);
    }
}
