package hackerton.wakeup.email.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Transactional
@Primary
public class EmailVerifyServiceImpl {
    private final Map<String, String> verificationCodes = new ConcurrentHashMap<>();
    private static final Duration EXPIRATION = Duration.ofMinutes(10);
}
