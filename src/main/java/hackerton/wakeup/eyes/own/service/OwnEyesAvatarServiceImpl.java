package hackerton.wakeup.eyes.own.service;

import hackerton.wakeup.eyes.own.entity.OwnEyesAvatar;
import hackerton.wakeup.eyes.own.entity.OwnEyesAvatarId;
import hackerton.wakeup.eyes.own.repository.OwnEyesAvatarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Primary
public class OwnEyesAvatarServiceImpl implements OwnEyesAvatarService {

    private final OwnEyesAvatarRepository ownEyesAvatarRepository;

    @Override
    public List<OwnEyesAvatar> getAllOwnEyesAvatars(OwnEyesAvatarId id) {
        return ownEyesAvatarRepository.findAllById(id);
    }

    @Override
    public boolean isOwnEyesAvatarExists(Long eyes_id) {
        return false;
    }
}
