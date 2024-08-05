package hackerton.wakeup.alarm.controller;

import hackerton.wakeup.alarm.service.AlarmService;
import hackerton.wakeup.alarm.service.dto.AlarmPostRequest;
import hackerton.wakeup.alarm.service.dto.AlarmPostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/alarm")
public class AlarmController {
    private final AlarmService alarmService;

    @PostMapping("")
    public ResponseEntity<AlarmPostResponse> postAlarm(@RequestBody AlarmPostRequest alarmPostRequest) {
        return ResponseEntity.ok(alarmService.postAlarm(
                alarmPostRequest.getNickname(),
                alarmPostRequest.getTag(),
                alarmPostRequest.getIsSuccess()
        ));
    }
}
