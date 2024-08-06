package hackerton.wakeup.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaConfig {
    // JpaConfig 클래스는 Auditing 기능을 활성화합니다.
}
