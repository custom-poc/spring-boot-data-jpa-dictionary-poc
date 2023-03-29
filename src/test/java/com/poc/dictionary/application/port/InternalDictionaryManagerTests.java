package com.poc.dictionary.application.port;

import com.poc.dictionary.domain.model.ProviderAppealReasonDictionary;
import com.poc.dictionary.domain.model.InternalDictionary;
import core.base.BasePostgreSqlIntegrationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.poc.dictionary.core.enumeration.InternalDictionaryType.PROVIDER_APPEAL_REASON;

@SpringBootTest
class InternalDictionaryManagerTests extends BasePostgreSqlIntegrationTest {

    @Autowired
    InternalDictionaryManager manager;

    @Test
    void loadAllAppealReasonsTest() {
        // Given
        final InternalDictionaryService<ProviderAppealReasonDictionary> service = manager.service(PROVIDER_APPEAL_REASON);
        // When
        final List<? extends InternalDictionary> dictionaries = service.loadAll();
        // Then
        Assertions.assertFalse(dictionaries.isEmpty());
    }

}
