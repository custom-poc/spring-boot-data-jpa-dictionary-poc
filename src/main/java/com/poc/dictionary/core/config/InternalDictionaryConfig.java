package com.poc.dictionary.core.config;

import com.poc.dictionary.adapter.output.repository.internal.DefaultInternalDictionaryJpaRepository;
import com.poc.dictionary.application.port.InternalDictionaryService;
import com.poc.dictionary.application.service.DefaultInternalDictionaryService;
import com.poc.dictionary.application.service.data.InternalDictionaryMetadata;
import com.poc.dictionary.core.enumeration.InternalDictionaryType;
import com.poc.dictionary.domain.model.AppealReasonDictionary;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class InternalDictionaryConfig {

    private final EntityManager entityManager;

    @Autowired
    public InternalDictionaryConfig(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Bean
    public InternalDictionaryService<AppealReasonDictionary> appealReasonDictionaryService() {
        final var repository = DefaultInternalDictionaryJpaRepository.<AppealReasonDictionary>builder()
                .internalDictionaryType(InternalDictionaryType.APPEAL_REASON)
                .modelClass(AppealReasonDictionary.class)
                .entityManager(entityManager)
                .build();
        final InternalDictionaryMetadata metadata = InternalDictionaryMetadata.builder()
                .ordered(Boolean.TRUE)
                .build();
        return DefaultInternalDictionaryService.<AppealReasonDictionary>builder()
                .repository(repository)
                .metadata(metadata)
                .build();
    }

}
