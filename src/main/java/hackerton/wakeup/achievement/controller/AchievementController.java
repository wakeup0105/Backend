package hackerton.wakeup.achievement.controller;

import hackerton.wakeup.achievement.service.AchievementService;
import hackerton.wakeup.achievement.service.dto.AchievementRequest;
import hackerton.wakeup.achievement.service.dto.GetAchievementResponse;
import hackerton.wakeup.achievement.service.dto.GetGoalResponse;
import hackerton.wakeup.alarm.service.dto.AlarmPostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/achievement")
public class AchievementController {
    private final AchievementService achievementService;

    @PostMapping("")
    public ResponseEntity<Map<String, Map<String, GetAchievementResponse>>> getAchievement(
            @RequestBody AchievementRequest achievementRequest
    ) {
        return ResponseEntity.ok(achievementService.getAchievement(achievementRequest.getNickname(), achievementRequest.getTag()));
    }
}
