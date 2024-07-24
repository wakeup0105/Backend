package hackerton.wakeup.memberInfo.service;

import hackerton.wakeup.member.entity.Member;
import hackerton.wakeup.memberInfo.entity.MemberInfo;
import hackerton.wakeup.memberInfo.entity.MemberInfoId;
import hackerton.wakeup.memberInfo.repository.MemberInfoRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Primary
public class MemberInfoServiceImpl implements MemberInfoService{
    private final MemberInfoRepository memberInfoRepository;

    @Override
    public boolean checkNicknameAndTagDuplication(String nickname, String tag) {
        return memberInfoRepository.existsByNicknameAndTag(nickname, tag);
    }

    @Override
    public String settingNickname(Member member, String nickname) {
        String tag = "0000";
        while (memberInfoRepository.existsByNicknameAndTag(nickname, tag)){
            tag = RandomStringUtils.randomNumeric(4);
        }
        memberInfoRepository.save();
        return nickname + "#" + tag;
    }

    @Override
    public MemberInfo findById(MemberInfoId id) {
        return memberInfoRepository.findById(id).orElse(null);
    }

    @Override
    public MemberInfo findByMemberId(Long member_id) {
        return memberInfoRepository.findByIdMember(member_id).orElse(null);
    }
}
