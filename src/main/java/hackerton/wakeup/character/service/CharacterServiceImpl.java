package hackerton.wakeup.character.service;

import hackerton.wakeup.character.entity.Character;
import hackerton.wakeup.character.repository.CharacterRepository;
import hackerton.wakeup.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Primary
public class CharacterServiceImpl implements CharacterService {
    private final CharacterRepository characterRepository;

    @Override
    public Character initCharacter(Member member) {
        return null;
    }

    @Override
    public Character getByMemberId(Long member_id) {
        return null;
    }
}
