package hackerton.wakeup.member.service;

import hackerton.wakeup.member.entity.Member;
import hackerton.wakeup.member.entity.dto.request.JoinRequestDTO;

public interface MemberService {
    boolean checkEmailDuplication(String email);
    void joinMember(JoinRequestDTO req);
}
