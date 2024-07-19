package hackerton.wakeup.member.service;

import hackerton.wakeup.member.entity.Member;

public interface MemberService {
    boolean checkEmailDuplication(String email);
}
