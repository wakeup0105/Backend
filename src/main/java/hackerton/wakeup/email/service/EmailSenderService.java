package hackerton.wakeup.email.service;

public interface EmailSenderService {
    public void sendVerificationCode(String to, String code);
    public String formatTime(int time);
}
