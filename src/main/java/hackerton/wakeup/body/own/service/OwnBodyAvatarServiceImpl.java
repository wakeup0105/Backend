package hackerton.wakeup.body.own.service;

import hackerton.wakeup.body.own.entity.dto.OwnBodyDtoConverter;
import hackerton.wakeup.body.own.entity.dto.response.AllOwnBodyResponseDTO;
import hackerton.wakeup.body.own.repository.OwnBodyAvatarRepository;
import hackerton.wakeup.character.entity.CharacterId;
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
    private final OwnBodyAvatarRepository ownBodyAvatarRepository;

    @Override
    public List<AllOwnBodyResponseDTO> getAllOwnBodyAvatars(CharacterId id) {
        return ownBodyAvatarRepository.findAllByCharacterId(id).stream()
                .map(OwnBodyDtoConverter::allOwnBodyResponseConverter)
                .collect(Collectors.toList());
    }
}
