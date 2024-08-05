package hackerton.wakeup.achievement.Repository;

import hackerton.wakeup.achievement.domain.Achievement;
import hackerton.wakeup.member.entity.Member;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT a FROM Achievement a WHERE a.member = :member AND a.date = :date")
    Optional<Achievement> findByMemberAndDateWithLock(@Param("member") Member member, @Param("date") String date);
    Optional<Achievement> findByMemberAndDate(Member member, String date);
}
