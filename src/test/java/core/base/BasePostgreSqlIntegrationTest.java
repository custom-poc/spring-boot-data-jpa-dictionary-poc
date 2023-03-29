package core.base;

import org.springframework.lang.NonNull;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

/**
 * Base abstraction for integration tests with PostgreSQL database
 *
 * @author Serhey Doroshenko
 * @see BaseIntegrationTest
 */
@SuppressWarnings("resource")
public abstract class BasePostgreSqlIntegrationTest extends BaseIntegrationTest {

    private static final DockerImageName POSTGRE_SQL_IMAGE = DockerImageName.parse("postgres:15");
    private static final PostgreSQLContainer<?> POSTGRE_SQL_CONTAINER = new PostgreSQLContainer<>(POSTGRE_SQL_IMAGE)
            .withReuse(true);

    static {
        POSTGRE_SQL_CONTAINER.start();
    }

    @DynamicPropertySource
    public static void configure(@NonNull final DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", POSTGRE_SQL_CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.username", POSTGRE_SQL_CONTAINER::getUsername);
        registry.add("spring.datasource.password", POSTGRE_SQL_CONTAINER::getPassword);
    }

}
