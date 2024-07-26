package hackerton.wakeup.character.service;

import hackerton.wakeup.character.entity.Character;

public interface CharacterService {
    Character getByMemberId(Long member_id);
}
