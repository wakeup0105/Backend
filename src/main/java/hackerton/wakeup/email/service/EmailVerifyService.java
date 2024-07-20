package hackerton.wakeup.email.service;

public interface EmailVerifyService {
    public String generateVerificationCode(String email);
    public boolean verifyCode(String email, String code);
    public String randomCode();
}
