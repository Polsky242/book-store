package ru.polskiy.bookstore.integration;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.test.context.support.WithMockUser;
import org.testcontainers.containers.PostgreSQLContainer;


@SpringBootTest
@Transactional
@ActiveProfiles("test")
@Sql({"classpath:sql/data.sql"})
@WithMockUser(username = "test@mail.ru", password = "test", authorities = {"ADMIN", "USER"})
public abstract class IntegrationTestBase {
    private static final PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:14");
    @BeforeAll
    static void runContainer(){
        container.start();
    }
    @DynamicPropertySource
    static void postgresProperty(DynamicPropertyRegistry dpr){
        dpr.add("spring.datasource.url",container::getJdbcUrl);
    }
}
