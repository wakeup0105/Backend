package hackerton.wakeup.memberInfo.entity.dto;

import hackerton.wakeup.memberInfo.entity.MemberInfo;
import hackerton.wakeup.memberInfo.entity.dto.request.SetIntroductionRequestDTO;

public class MemberInfoDtoConverter {

    public static MemberInfo setIntroductionRequestConverter(MemberInfo memberInfo, SetIntroductionRequestDTO req){
        return MemberInfo.builder()
                .id(memberInfo.getId())
                .nickname(memberInfo.getNickname())
                .tag(memberInfo.getTag())
                .introduction(req.getIntroduction())
                .build();
    }
}
