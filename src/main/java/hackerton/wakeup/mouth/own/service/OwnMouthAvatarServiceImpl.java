package hackerton.wakeup.mouth.own.service;

import hackerton.wakeup.character.entity.CharacterId;
import hackerton.wakeup.mouth.own.entity.dto.OwnMouthDtoConverter;
import hackerton.wakeup.mouth.own.entity.dto.response.AllOwnMouthResponseDTO;
import hackerton.wakeup.mouth.own.repository.OwnMouthAvatarRepository;
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
    private final OwnMouthAvatarRepository ownMouthAvatarRepository;

    @Override
    public List<AllOwnMouthResponseDTO> getAllOwnMouthsAvatar(CharacterId id) {
        return ownMouthAvatarRepository.findAllByCharacterId(id).stream()
                .map(OwnMouthDtoConverter::allOwnMouthResponseConverter)
                .collect(Collectors.toList());
    }
}
