package hackerton.wakeup.member.service;

import hackerton.wakeup.member.entity.Member;
import hackerton.wakeup.member.entity.dto.request.ChangePasswordRequestDTO;
import hackerton.wakeup.member.entity.dto.request.JoinRequestDTO;
import hackerton.wakeup.member.entity.dto.request.LoginRequestDTO;
import hackerton.wakeup.refresh.entity.RefreshToken;

import java.util.Optional;

public interface MemberService {
    boolean checkEmailDuplication(String email);
    void joinMember(JoinRequestDTO req);
    Member loginMember(LoginRequestDTO req);
    RefreshToken createRefreshToken(String email, Long expiresInSeconds);
    void changePassword(String email, ChangePasswordRequestDTO req);
    void sendVerificationEmail(String email);
    Optional<Member> getMemberById(Long id);
    Optional<Member> getMemberByEmail(String email);
}
