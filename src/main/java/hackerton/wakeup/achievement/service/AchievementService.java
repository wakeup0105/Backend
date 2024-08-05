package hackerton.wakeup.achievement.service;

import hackerton.wakeup.achievement.Repository.AchievementRepository;
import hackerton.wakeup.achievement.domain.Achievement;
import hackerton.wakeup.achievement.service.dto.GetAchievementResponse;
import hackerton.wakeup.achievement.service.dto.GetGoalResponse;
import hackerton.wakeup.character.entity.Character;
import hackerton.wakeup.character.repository.CharacterRepository;
import hackerton.wakeup.member.entity.Member;
import hackerton.wakeup.memberInfo.entity.MemberInfo;
import hackerton.wakeup.memberInfo.repository.MemberInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AchievementService {
    private final MemberInfoRepository memberInfoRepository;
    private final AchievementRepository achievementRepository;
    private final CharacterRepository characterRepository;

    @Transactional
    public Map<String, Map<String, GetAchievementResponse>> getAchievement(String nickname, String tag) {
        MemberInfo memberInfo = memberInfoRepository.findByNicknameAndTag(nickname, tag).get();
        LocalDateTime now = LocalDateTime.now();

        // 'yyMMdd' 형식으로 변환하기 위한 포맷터를 생성
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");

        // 앞 7일과 뒤 7일 간의 날짜와 업적 정보를 맵에 저장
        Map<String, Map<String, GetAchievementResponse>> lastWeekDateMap = new HashMap<>();
        Map<String, Map<String, GetAchievementResponse>> nextWeekDateMap = new HashMap<>();

        // 앞 14일
        populateDateMap(lastWeekDateMap, memberInfo, now, -14, 0, formatter);

        // 뒤 7일
        populateDateMap(nextWeekDateMap, memberInfo, now, 1, 7, formatter);

        // 결합하여 반환
        Map<String, Map<String, GetAchievementResponse>> combinedMap = new HashMap<>();
        combinedMap.putAll(lastWeekDateMap);
        combinedMap.putAll(nextWeekDateMap);

        return combinedMap;
    }

    private void populateDateMap(Map<String, Map<String, GetAchievementResponse>> dateMap, MemberInfo memberInfo, LocalDateTime now, int startOffset, int endOffset, DateTimeFormatter formatter) {
        for (int i = startOffset; i <= endOffset; i++) {
            LocalDate date = now.toLocalDate().plusDays(i);
            String formatted = date.format(formatter);
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            Achievement achievement = achievementRepository.findByMemberAndDate(memberInfo.getMember(), formatted)
                    .orElse(
                        Achievement.builder()
                                .success(0)
                                .failure(0)
                                .date(formatted)
                                .member(memberInfo.getMember())
                                .build()
                );
            GetAchievementResponse getAchievementResponse = new GetAchievementResponse(achievement);
            dateMap.put(formatted, Map.of(dayOfWeek.toString(), getAchievementResponse));
        }
    }
    public GetGoalResponse getGoal(String nickname, String tag) {
        MemberInfo memberInfo = memberInfoRepository.findByNicknameAndTag(nickname, tag).get();
        Member member = memberInfo.getMember();
        Character character = characterRepository.findByIdMember(member.getId()).get();

        Long requiredExp = character.getLevel() * 5L;
        Long currentExp = character.getExp();

        // 비율 계산 및 백분율 계산
        float ratio = (float) currentExp / (float) requiredExp * 100;

        // 소수점 둘째 자리까지 반올림
        float percentage = Math.round(ratio * 100) / 100.0f;

        // Dto 생성 및 반환
        return new GetGoalResponse(member.getId(), requiredExp, currentExp, percentage);
    }

}
