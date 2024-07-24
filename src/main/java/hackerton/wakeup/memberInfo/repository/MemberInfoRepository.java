package hackerton.wakeup.memberInfo.repository;

import hackerton.wakeup.member.entity.Member;
import hackerton.wakeup.memberInfo.entity.MemberInfo;
import hackerton.wakeup.memberInfo.entity.MemberInfoId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberInfoRepository extends JpaRepository<MemberInfo, MemberInfoId> {
    boolean existsByNicknameAndTag(String nickname, String tag);

    Optional<MemberInfo> findById(MemberInfoId id);
    Optional<MemberInfo> findByIdMember(Member member);
}
