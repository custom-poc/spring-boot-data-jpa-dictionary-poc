package com.poc.dictionary.core.config;

import com.poc.dictionary.adapter.output.repository.internal.DefaultInternalDictionaryJpaRepository;
import com.poc.dictionary.application.port.InternalDictionaryService;
import com.poc.dictionary.application.service.DefaultInternalDictionaryService;
import com.poc.dictionary.application.service.data.InternalDictionaryMetadata;
import com.poc.dictionary.core.enumeration.InternalDictionaryType;
import com.poc.dictionary.domain.model.ProviderAppealReasonDictionary;
import com.poc.dictionary.domain.model.ProviderAppealRejectionReasonDictionary;
import com.poc.dictionary.domain.model.ProviderAppealViolationReasonDictionary;
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
    public InternalDictionaryService<ProviderAppealReasonDictionary> providerAppealReasonDictionaryService() {
        final var repository = DefaultInternalDictionaryJpaRepository.<ProviderAppealReasonDictionary>builder()
                .internalDictionaryType(InternalDictionaryType.PROVIDER_APPEAL_REASON)
                .modelClass(ProviderAppealReasonDictionary.class)
                .entityManager(entityManager)
                .build();
        final InternalDictionaryMetadata metadata = InternalDictionaryMetadata.builder()
                .ordered(Boolean.TRUE)
                .build();
        return DefaultInternalDictionaryService.<ProviderAppealReasonDictionary>builder()
                .repository(repository)
                .metadata(metadata)
                .build();
    }

    @Bean
    public InternalDictionaryService<ProviderAppealViolationReasonDictionary> providerAppealViolationDictionaryService() {
        final var repository = DefaultInternalDictionaryJpaRepository.<ProviderAppealViolationReasonDictionary>builder()
                .internalDictionaryType(InternalDictionaryType.PROVIDER_APPEAL_VIOLATION_REASON)
                .modelClass(ProviderAppealViolationReasonDictionary.class)
                .entityManager(entityManager)
                .build();
        final InternalDictionaryMetadata metadata = InternalDictionaryMetadata.builder()
                .ordered(Boolean.TRUE)
                .build();
        return DefaultInternalDictionaryService.<ProviderAppealViolationReasonDictionary>builder()
                .repository(repository)
                .metadata(metadata)
                .build();
    }

    @Bean
    public InternalDictionaryService<ProviderAppealRejectionReasonDictionary> providerAppealRejectionReasonDictionaryService() {
        final var repository = DefaultInternalDictionaryJpaRepository.<ProviderAppealRejectionReasonDictionary>builder()
                .internalDictionaryType(InternalDictionaryType.PROVIDER_APPEAL_REJECTION_REASON)
                .modelClass(ProviderAppealRejectionReasonDictionary.class)
                .entityManager(entityManager)
                .build();
        final InternalDictionaryMetadata metadata = InternalDictionaryMetadata.builder()
                .ordered(Boolean.TRUE)
                .build();
        return DefaultInternalDictionaryService.<ProviderAppealRejectionReasonDictionary>builder()
                .repository(repository)
                .metadata(metadata)
                .build();
    }

}
