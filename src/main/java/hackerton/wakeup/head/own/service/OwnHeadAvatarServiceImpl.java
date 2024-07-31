package hackerton.wakeup.head.own.service;

import hackerton.wakeup.character.entity.CharacterId;
import hackerton.wakeup.head.own.entity.dto.OwnHeadDtoConverter;
import hackerton.wakeup.head.own.entity.dto.response.AllOwnHeadResponseDTO;
import hackerton.wakeup.head.own.repository.OwnHeadAvatarRepository;
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
    private final OwnHeadAvatarRepository ownHeadAvatarRepository;

    @Override
    public List<AllOwnHeadResponseDTO> getAllOwnHeadAvatar(CharacterId id) {
        return ownHeadAvatarRepository.findAllByCharacterId(id).stream()
                .map(OwnHeadDtoConverter::allOwnHeadResponseConverter)
                .collect(Collectors.toList());
    }
}
