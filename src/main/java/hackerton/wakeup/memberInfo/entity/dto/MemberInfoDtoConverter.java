package hackerton.wakeup.memberInfo.entity.dto;

import hackerton.wakeup.memberInfo.entity.MemberInfo;
import hackerton.wakeup.memberInfo.entity.dto.request.SetIntroductionRequestDTO;
import hackerton.wakeup.memberInfo.entity.dto.request.SetNicknameRequestDTO;

public class MemberInfoDtoConverter {

    public static MemberInfo setIntroductionRequestConverter(MemberInfo memberInfo, SetIntroductionRequestDTO req){
        return MemberInfo.builder()
                .id(memberInfo.getId())
                .member(memberInfo.getMember())
                .nickname(memberInfo.getNickname())
                .tag(memberInfo.getTag())
                .introduction(req.getIntroduction())
                .build();
    }

    public static MemberInfo setNicknameRequestConverter(MemberInfo memberInfo, SetNicknameRequestDTO req, String tag){
        return MemberInfo.builder()
                .id(memberInfo.getId())
                .member(memberInfo.getMember())
                .nickname(req.getNickname())
                .tag(tag)
                .introduction(memberInfo.getIntroduction())
                .build();
    }
}
