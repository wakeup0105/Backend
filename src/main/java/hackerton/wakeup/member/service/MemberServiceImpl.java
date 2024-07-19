package hackerton.wakeup.member.service;

import hackerton.wakeup.member.entity.dto.request.JoinRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Primary
public class MemberServiceImpl implements MemberService {
    @Override
    public boolean checkEmailDuplication(String email) {
        return false;
    }

    @Override
    public void joinMember(JoinRequestDTO req) {

    }
}
