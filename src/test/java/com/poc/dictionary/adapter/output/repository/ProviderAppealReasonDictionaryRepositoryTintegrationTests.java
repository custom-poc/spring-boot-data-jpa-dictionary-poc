package com.poc.dictionary.adapter.output.repository;

import com.poc.dictionary.domain.model.ProviderAppealReasonDictionary;
import core.base.BasePostgreSqlIntegrationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@SpringBootTest
class ProviderAppealReasonDictionaryRepositoryTintegrationTests extends BasePostgreSqlIntegrationTest {

    @Autowired
    ProviderAppealReasonDictionaryRepository repository;

    @Test
    void createOneTest() {
        // given
        final long priority = 1;
        final String caption = "Caption-1";
        final String description = "Description-1";
        final ProviderAppealReasonDictionary providerAppealReasonDictionary = new ProviderAppealReasonDictionary();
        providerAppealReasonDictionary.setDescription(description);
        providerAppealReasonDictionary.setCaption(caption);
        providerAppealReasonDictionary.setPriority(priority);
        // when
        final ProviderAppealReasonDictionary result = repository.save(providerAppealReasonDictionary);
        // then
        Assertions.assertNotNull(result);
        Assertions.assertNotNull(result.getId());
        Assertions.assertEquals(caption, result.getCaption());
        Assertions.assertEquals(priority, result.getPriority());
        Assertions.assertEquals(description, result.getDescription().orElse(null));
    }

    @Test
    @Sql(scripts = {"classpath:fixture/internal_dictionary_insert.sql"})
    @Sql(executionPhase = AFTER_TEST_METHOD, scripts = {"classpath:fixture/internal_dictionary_truncate.sql"})
    void findAllTest() {
        // when
        final List<ProviderAppealReasonDictionary> result = repository.findAll();
        // then
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(2, result.size());
    }

}
