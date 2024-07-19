package hackerton.wakeup.member.service;

import hackerton.wakeup.member.entity.Member;
import hackerton.wakeup.member.entity.dto.request.JoinRequestDTO;
import hackerton.wakeup.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Primary
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public boolean checkEmailDuplication(String email) {
        return memberRepository.existsByEmail(email);
    }

    @Override
    public void joinMember(JoinRequestDTO req) {
        memberRepository.save(req.toEntity());
    }

    @Override
    public Member getMemberById(Long id) {
        return null;
    }

    @Override
    public Member getMemberByEmail(String email) {
        return null;
    }
}
