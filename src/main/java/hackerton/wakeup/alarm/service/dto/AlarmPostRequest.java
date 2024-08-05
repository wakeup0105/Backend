package hackerton.wakeup.alarm.service.dto;

import lombok.Data;

@Data
public class AlarmPostRequest {
    private String nickname;
    private String tag;
    private Boolean isSuccess;
}
