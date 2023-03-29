package core.base;

import core.config.CoreTestConfig;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.junit.jupiter.Testcontainers;

import static com.poc.dictionary.core.constant.ApplicationProfiles.TEST;

/**
 * Base abstraction for integration tests
 *
 * @author Serhey Doroshenko
 */
@ActiveProfiles({TEST})
@Import({CoreTestConfig.class})
@Testcontainers(disabledWithoutDocker = true)
public abstract class BaseIntegrationTest {
}
