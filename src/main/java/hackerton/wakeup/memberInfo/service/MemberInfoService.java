package hackerton.wakeup.memberInfo.service;

import hackerton.wakeup.memberInfo.entity.MemberInfo;
import hackerton.wakeup.memberInfo.entity.MemberInfoId;

import java.util.Optional;

public interface MemberInfoService {
    boolean checkNicknameAndTagDuplication(String nickname, String tag);
    String settingNickname(String nickname, String tag);
    Optional<MemberInfo> findById(MemberInfoId id);
    Optional<MemberInfo> findByMemberId(Long member_id);
}
