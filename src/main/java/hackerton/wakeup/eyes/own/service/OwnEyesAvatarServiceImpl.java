package hackerton.wakeup.eyes.own.service;

import hackerton.wakeup.character.entity.CharacterId;
import hackerton.wakeup.eyes.own.entity.OwnEyesAvatar;
import hackerton.wakeup.eyes.own.entity.dto.OwnEyesDtoConverter;
import hackerton.wakeup.eyes.own.entity.dto.response.AllOwnEyesResponseDTO;
import hackerton.wakeup.eyes.own.repository.OwnEyesAvatarRepository;
import hackerton.wakeup.eyes.part.entity.Eyes;
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

    private final OwnEyesAvatarRepository ownEyesAvatarRepository;

    @Override
    public List<AllOwnEyesResponseDTO> getAllOwnEyesAvatars(CharacterId id) {
        return ownEyesAvatarRepository.findAllByCharacterId(id).stream()
                .map(OwnEyesDtoConverter::allOwnEyesResponseConverter)
                .collect(Collectors.toList());
    }
}
