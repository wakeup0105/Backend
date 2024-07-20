package hackerton.wakeup.email.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
@Primary
public class EmailVerifyServiceImpl implements EmailVerifyService {
    private final Map<String, String> verificationCodes = new ConcurrentHashMap<>();
    private static final Duration EXPIRATION = Duration.ofMinutes(10);

    @Override
    public String generateVerificationCode(String email) {
        String code = randomCode();
        verificationCodes.put(email, code);

        //일정 시간이 지나면 Map 에서 키를 삭제하는 로직 ( 수행 로직, 시간제한, 시간단위 )
        Executors.newSingleThreadScheduledExecutor().schedule(
                () -> verificationCodes.remove(email),
                EXPIRATION.toMillis(),
                TimeUnit.MILLISECONDS
        );

        return code;
    }

    @Override
    public boolean verifyCode(String email, String code) {
        //Map 에서 이메일을 제거하고 해당 이메일에 매칭되는 code 가 입력받은 code 와 같은지 확인
        return Optional.ofNullable(verificationCodes.remove(email))
                .map(storageCode -> storageCode.equals(code))
                .orElse(false);
    }

    @Override
    public String randomCode() {
        return RandomStringUtils.randomAlphanumeric(8);
    }
}
