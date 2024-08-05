package hackerton.wakeup.alarm.service.dto;

import hackerton.wakeup.character.entity.Character;
import hackerton.wakeup.member.entity.Member;
import hackerton.wakeup.memberInfo.entity.MemberInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AlarmPostResponse {
    private MemberInfo memberInfo;
    private Character character;
    private String message;

    public AlarmPostResponse(MemberInfo memberInfo, Character character, String message) {
        this.memberInfo = memberInfo;
        this.message = message;
        this.character = character;
    }
}
