package hackerton.wakeup.email.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class EmailVerifyServiceImplTest {

    EmailVerifyService emailVerifyService;
    @BeforeEach
    public void setUp() {
        emailVerifyService = new EmailVerifyServiceImpl();
    }

    @Test
    @DisplayName("해당 이메일로 발급 받은 코드와 일치하다면 true")
    void verificationLogicTest() {
        //given
        String email = "test@test.com";
        //when
        String verificationCode = emailVerifyService.generateVerificationCode(email);
        //then
        assertThat(emailVerifyService.verifyCode(email, verificationCode)).isEqualTo(true);
    }
}