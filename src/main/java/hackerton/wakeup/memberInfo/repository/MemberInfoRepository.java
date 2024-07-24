package hackerton.wakeup.memberInfo.repository;

import hackerton.wakeup.memberInfo.entity.MemberInfo;
import hackerton.wakeup.memberInfo.entity.MemberInfoId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberInfoRepository extends JpaRepository<MemberInfo, MemberInfoId> {
    boolean existsByNicknameAndTag(String nickname, String tag);
}
