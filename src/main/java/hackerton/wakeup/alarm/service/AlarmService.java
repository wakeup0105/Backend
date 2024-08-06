package hackerton.wakeup.alarm.service;

import hackerton.wakeup.achievement.Repository.AchievementRepository;
import hackerton.wakeup.achievement.domain.Achievement;
import hackerton.wakeup.alarm.service.dto.AlarmPostResponse;
import hackerton.wakeup.character.entity.Character;
import hackerton.wakeup.character.repository.CharacterRepository;
import hackerton.wakeup.member.entity.Member;
import hackerton.wakeup.member.repository.MemberRepository;
import hackerton.wakeup.memberInfo.entity.MemberInfo;
import hackerton.wakeup.memberInfo.repository.MemberInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AlarmService {
    private final MemberRepository memberRepository;
    private final MemberInfoRepository memberInfoRepository;
    private final CharacterRepository characterRepository;
    private final AchievementRepository achievementRepository;

    // 구간별 레벨에 따른 Point 획득 Map
    private final Map<String, Integer> levelRangePointMap = new HashMap<>() {{
        put("1-4", 10);
        put("5-9", 30);
        put("10-14", 70);
        put("15-19", 100);
        put("20-24", 200);
        put("25-29", 300);
        put("30-34", 400);
        put("35-39", 500);
        put("40-44", 700);
    }};


    public AlarmPostResponse postAlarm(String nickname, String tag, Boolean isSuccess) {
        MemberInfo memberInfo = memberInfoRepository.findByNicknameAndTag(nickname, tag).get();
        Member member = memberInfo.getMember();
        LocalDateTime now = LocalDateTime.now();
        String message = "";

        // 'yyMMdd' 형식으로 변환하기 위한 포맷터를 생성
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");

        // 현재 시간을 'yyMMdd' 형식의 문자열로 변환
        String formattedDate = now.format(formatter);
        Character character = characterRepository.findByIdMember(member.getId()).get();

        if (isSuccess) {
            Integer characterLevel = character.getLevel();
            Long characterExp = character.getExp();
            characterExp = characterExp + 1;

            // exp 레벨업 기준에 도달 했을 때와 아닐 때
            if (characterExp > characterLevel * 5) {
                Character modifiedCharacter = character.toBuilder()
                        .level(characterLevel + 1)
                        .exp(0L)
                        .build();
                characterRepository.save(modifiedCharacter);
                Integer getPoint = getLevelUpPoint(characterLevel+1);
                Member modifiedMember = member.toBuilder()
                        .point(member.getPoint() + getPoint)
                        .build();
                memberRepository.save(modifiedMember);
            } else {
                Character modifiedCharacter = character.toBuilder()
                        .exp(characterExp)
                        .build();
                characterRepository.save(modifiedCharacter);
            }
            Achievement achievement = achievementRepository.findByMemberAndDate(memberInfo.getMember(), formattedDate)
                    .orElse(
                            Achievement.builder()
                                    .success(1)
                                    .failure(0)
                                    .date(formattedDate)
                                    .member(member)
                                    .build()
                    );
            Achievement modifiedachievement = achievement.toBuilder()
                    .success(achievement.getSuccess()+1)
                    .build();
            achievementRepository.save(modifiedachievement);

            message = "성공했습니다";
        } else {
            Achievement achievement = achievementRepository.findByMemberAndDate(memberInfo.getMember(), formattedDate)
                    .orElse(
                            Achievement.builder()
                                    .success(0)
                                    .failure(1)
                                    .date(formattedDate)
                                    .member(member)
                                    .build()
                    );
            Achievement modifiedachievement = achievement.toBuilder()
                    .failure(achievement.getFailure()+1)
                    .build();
            achievementRepository.save(modifiedachievement);
            message = "실패했습니다";
        }
        return new AlarmPostResponse(memberInfo, character, message);
    }
    
    
    // 레벨업에 따른 포인트 획득 메서드
    private int getLevelUpPoint(int level) {
        if (level >= 1 && level <= 4) {
            return levelRangePointMap.get("1-4");
        } else if (level >= 5 && level <= 9) {
            return levelRangePointMap.get("5-9");
        } else if (level >= 10 && level <= 14) {
            return levelRangePointMap.get("10-14");
        } else if (level >= 15 && level <= 19) {
            return levelRangePointMap.get("15-19");
        } else if (level >= 20 && level <= 24) {
            return levelRangePointMap.get("20-24");
        } else if (level >= 25 && level <= 29) {
            return levelRangePointMap.get("25-29");
        } else if (level >= 30 && level <= 34) {
            return levelRangePointMap.get("30-34");
        } else if (level >= 35 && level <= 39) {
            return levelRangePointMap.get("35-39");
        } else if (level >= 40 && level <= 44) {
            return levelRangePointMap.get("40-44");
        } else {
            // 기본값을 사용하거나 예외를 던질 수 있음
            throw new IllegalArgumentException("레벨에 대한 경험치 기준을 찾을 수 없습니다.");
        }
    }

}
