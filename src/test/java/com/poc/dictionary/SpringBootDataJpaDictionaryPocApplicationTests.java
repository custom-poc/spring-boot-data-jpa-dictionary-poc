package com.poc.dictionary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class SpringBootDataJpaDictionaryPocApplicationTests {

    static final Logger logger = LoggerFactory.getLogger(SpringBootDataJpaDictionaryPocApplicationTests.class);

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> {
            for (int i = 0; i < 10; i++) {
                logger.info("UUID-{}: {}", i + 1, UUID.randomUUID());
            }
        });
    }

}
