package hackerton.wakeup.memberInfo.repository;

import hackerton.wakeup.memberInfo.entity.MemberInfo;
import hackerton.wakeup.memberInfo.entity.MemberInfoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberInfoRepository extends JpaRepository<MemberInfo, MemberInfoId> {
    boolean existsByNickname(String nickname);
}
