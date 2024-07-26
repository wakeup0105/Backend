package hackerton.wakeup.character.service;

import hackerton.wakeup.character.entity.Character;
import hackerton.wakeup.member.entity.Member;

public interface CharacterService {
    void initCharacter(Member member);
    Character getByMemberId(Long member_id);
}
