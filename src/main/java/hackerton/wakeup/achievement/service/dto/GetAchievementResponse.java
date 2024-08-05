package hackerton.wakeup.achievement.service.dto;

import hackerton.wakeup.achievement.domain.Achievement;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetAchievementResponse {
    private Long id;
    private Integer success;
    private Integer failure;
    private String date;

    public GetAchievementResponse (Achievement achievement) {
        this.id = achievement.getId();
        this.success = achievement.getSuccess();
        this.failure = achievement.getFailure();
        this.date = achievement.getDate();
    }
}
