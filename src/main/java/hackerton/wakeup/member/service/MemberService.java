package hackerton.wakeup.member.service;

import hackerton.wakeup.member.entity.Member;
import hackerton.wakeup.member.entity.dto.request.JoinRequestDTO;
import hackerton.wakeup.member.entity.dto.request.LoginRequestDTO;

import java.util.Optional;

public interface MemberService {
    boolean checkEmailDuplication(String email);
    void joinMember(JoinRequestDTO req);
    Member loginMember(LoginRequestDTO req);
    void sendVerificationEmail(String email);
    Optional<Member> getMemberById(Long id);
    Optional<Member> getMemberByEmail(String email);
}
