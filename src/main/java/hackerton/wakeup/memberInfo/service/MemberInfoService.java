package hackerton.wakeup.memberInfo.service;

import hackerton.wakeup.member.entity.Member;
import hackerton.wakeup.memberInfo.entity.MemberInfo;
import hackerton.wakeup.memberInfo.entity.MemberInfoId;

import java.util.Optional;

public interface MemberInfoService {
    boolean checkNicknameAndTagDuplication(String nickname, String tag);
    String settingNickname(Member member, String nickname);
    MemberInfo findById(MemberInfoId id);
    MemberInfo findByMemberId(Long member_id);
}
