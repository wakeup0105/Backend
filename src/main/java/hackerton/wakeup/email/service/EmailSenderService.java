package hackerton.wakeup.email.service;

import java.time.LocalTime;

public interface EmailSenderService {
    public void sendVerificationCode(String to, String code);
    public String formatTime(LocalTime now);
}
