package hackerton.wakeup.email.service;

public interface EmailVerifyService {
    public String generateVerificationCode(String email);
}
