package hackerton.wakeup.memberInfo.service;

import hackerton.wakeup.member.entity.Member;
import hackerton.wakeup.memberInfo.entity.MemberInfo;
import hackerton.wakeup.memberInfo.entity.MemberInfoId;
import hackerton.wakeup.memberInfo.entity.dto.MemberInfoDtoConverter;
import hackerton.wakeup.memberInfo.entity.dto.request.SetIntroductionRequestDTO;
import hackerton.wakeup.memberInfo.entity.dto.request.SetNicknameRequestDTO;
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
    public String settingNickname(Member member, SetNicknameRequestDTO req) {
        String tag = "0000";
        while (memberInfoRepository.existsByNicknameAndTag(req.getNickname(), tag)){
            tag = RandomStringUtils.randomNumeric(4);
        }
        MemberInfoId memberInfoId = MemberInfoId.builder().id(member.getId()).member(member.getId()).build();
        MemberInfo findMemberInfo = memberInfoRepository.findById(memberInfoId).orElse(null);
        if (findMemberInfo == null){
            memberInfoRepository.save(MemberInfo.builder()
                    .id(memberInfoId)
                    .member(member)
                    .nickname(req.getNickname())
                    .tag(tag)
                    .introduction(null).build());
        }
        else {
            memberInfoRepository.save(MemberInfoDtoConverter.setNicknameRequestConverter(findMemberInfo, req, tag));
        }
        return req.getNickname() + "#" + tag;
    }

    @Override
    public String settingIntroduction(Member member, SetIntroductionRequestDTO req) {
        memberInfoRepository.save(MemberInfoDtoConverter.setIntroductionRequestConverter(member.getMemberInfo(), req));
        return "한 줄 소개 설정 성공: " + req.getIntroduction();
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
