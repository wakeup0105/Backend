package hackerton.wakeup.memberInfo.service;

import hackerton.wakeup.memberInfo.entity.MemberInfo;
import hackerton.wakeup.memberInfo.entity.MemberInfoId;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Primary
public class MemberInfoServiceImpl implements MemberInfoService{
    @Override
    public boolean checkNicknameAndTagDuplication(String nickname, String tag) {
        return false;
    }

    @Override
    public String settingNickname(String nickname, String tag) {
        return "";
    }

    @Override
    public Optional<MemberInfo> findById(MemberInfoId id) {
        return Optional.empty();
    }

    @Override
    public Optional<MemberInfo> findByMemberId(Long member_id) {
        return Optional.empty();
    }
}
