package hackerton.wakeup.email.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
@Transactional
@Primary
@RequiredArgsConstructor
public class EmailSenderServiceImpl implements EmailSenderService {

    private final JavaMailSender mailSender;

    @Override
    public void sendVerificationCode(String to, String code) {
        LocalDate nowDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy. MM. dd.");

        LocalTime nowTime = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("이메일 인증 메일 발송");
        message.setText("""
                안녕하세요, 일오나입니다.
                요청 일시: %s
                요청 기기: %s
                
                위 환경에서 본 이메일 주소로 이메일 인증을 시도했습니다.
                본인이 맞다면 계속 진행해주세요.
                
                %s
                
                위 인증 번호의 유효 기간은 요청 시점으로부터 약 10분입니다.
                감사합니다.
                """
                .formatted(nowDate.format(dateTimeFormatter) + "시간 정보",
                "장치 정보",
                code));
        mailSender.send(message);
    }
}
