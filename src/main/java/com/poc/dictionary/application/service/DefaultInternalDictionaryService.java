package com.poc.dictionary.application.service;

import com.poc.dictionary.adapter.output.repository.InternalDictionaryJpaRepository;
import com.poc.dictionary.application.port.InternalDictionaryService;
import com.poc.dictionary.application.service.data.InternalDictionaryMetadata;
import com.poc.dictionary.core.enumeration.InternalDictionaryType;
import com.poc.dictionary.domain.model.InternalDictionary;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.UUID;

/**
 * Default implementation of the {@link InternalDictionaryService}
 *
 * @param <M> model
 * @author Serhey Doroshenko
 */
public class DefaultInternalDictionaryService<M extends InternalDictionary> implements InternalDictionaryService<M> {

    private final InternalDictionaryMetadata metadata;
    private final InternalDictionaryJpaRepository<M> repository;

    public DefaultInternalDictionaryService(final InternalDictionaryMetadata metadata, final InternalDictionaryJpaRepository<M> repository) {
        this.metadata = metadata;
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<M> loadAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public M saveOne(final M model) {
        return repository.saveOne(model);
    }

    @Override
    @Transactional(readOnly = true)
    public M loadById(final UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dictionary not found"));
    }

    @Override
    @Transactional
    public Boolean deleteById(final UUID id) {
        return repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<M> loadAllByRelationId(final UUID relationId) {
        return repository.findAllByRelationId(relationId);
    }

    @Override
    public InternalDictionaryType dictionaryType() {
        return repository.internalDictionaryType();
    }

    /* Builder */
    @NonNull
    public static <M extends InternalDictionary> Builder<M> builder() {
        return new Builder<>();
    }

    public static class Builder<M extends InternalDictionary> {

        private InternalDictionaryMetadata metadata;
        private InternalDictionaryJpaRepository<M> repository;

        public Builder<M> metadata(final InternalDictionaryMetadata metadata) {
            this.metadata = metadata;
            return this;
        }

        public Builder<M> repository(final InternalDictionaryJpaRepository<M> repository) {
            this.repository = repository;
            return this;
        }

        public DefaultInternalDictionaryService<M> build() {
            Assert.notNull(this.metadata, "metadata cannot be null");
            Assert.notNull(this.repository, "repository cannot be null");
            return new DefaultInternalDictionaryService<>(this.metadata, this.repository);
        }

    }

}
