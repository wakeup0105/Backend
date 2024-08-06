package hackerton.wakeup.achievement.service.dto;

import hackerton.wakeup.character.entity.Character;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;

@Data
@NoArgsConstructor
public class GetGoalResponse {
    private Long memberId;
    private Long requiredExp;
    private Long currentExp;
    private Float currentExpPerRequiredExp;
    public GetGoalResponse(Long memberId, Long requiredExp, Long currentExp, Float currentExpPerRequiredExp) {
        this.memberId = memberId;
        this.requiredExp = requiredExp;
        this.currentExp = currentExp;
        this.currentExpPerRequiredExp = currentExpPerRequiredExp;
    }
}
