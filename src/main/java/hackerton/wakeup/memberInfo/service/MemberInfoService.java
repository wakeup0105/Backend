package hackerton.wakeup.memberInfo.service;

import hackerton.wakeup.member.entity.Member;
import hackerton.wakeup.memberInfo.entity.MemberInfo;
import hackerton.wakeup.memberInfo.entity.MemberInfoId;
import hackerton.wakeup.memberInfo.entity.dto.request.SetIntroductionRequestDTO;
import hackerton.wakeup.memberInfo.entity.dto.request.SetNicknameRequestDTO;

import java.util.Optional;

public interface MemberInfoService {
    boolean checkNicknameAndTagDuplication(String nickname, String tag);
    void initMemberInfo(Member member);
    String settingNickname(Member member, SetNicknameRequestDTO req);
    String settingIntroduction(Member member, SetIntroductionRequestDTO req);
    MemberInfo findById(MemberInfoId id);
    MemberInfo findByMemberId(Long member_id);
}
