package com.poc.dictionary.adapter.output.repository.internal;

import com.poc.dictionary.adapter.output.repository.InternalDictionaryJpaRepository;
import com.poc.dictionary.core.enumeration.InternalDictionaryType;
import com.poc.dictionary.domain.model.InternalDictionary;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.jpa.HibernateHints;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Default implementation of the {@link InternalDictionaryJpaRepository}
 *
 * @param <M> model
 * @author Serhey Doroshenko
 */
public class DefaultInternalDictionaryJpaRepository<M extends InternalDictionary> implements InternalDictionaryJpaRepository<M> {

    private final Class<M> modelClass;
    private final EntityManager entityManager;
    private final InternalDictionaryType internalDictionaryType;

    public DefaultInternalDictionaryJpaRepository(final Class<M> modelClass,
                                                  final EntityManager entityManager,
                                                  final InternalDictionaryType internalDictionaryType) {
        this.modelClass = modelClass;
        this.entityManager = entityManager;
        this.internalDictionaryType = internalDictionaryType;
    }

    @Override
    @Transactional(readOnly = true)
    public List<M> findAll() {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<M> query = criteriaBuilder.createQuery(modelClass);
        return entityManager.createQuery(query.select(query.from(modelClass)))
                .setHint(HibernateHints.HINT_READ_ONLY, Boolean.TRUE)
                .getResultList();
    }

    @Override
    @Transactional
    public M saveOne(@NonNull final M model) {
        if (model.isNew()) {
            entityManager.persist(model);
            return model;
        }
        return entityManager.merge(model);
    }

    @Override
    @Transactional
    public Boolean deleteById(final UUID id) {
        return findById(id).map(model -> {
            entityManager.remove(model);
            return Boolean.TRUE;
        }).orElse(Boolean.FALSE);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<M> findById(final UUID id) {
        return Optional.ofNullable(entityManager.find(modelClass, id));
    }

    @Override
    public InternalDictionaryType internalDictionaryType() {
        return internalDictionaryType;
    }

    /* Builder */
    @NonNull
    public static <M extends InternalDictionary> Builder<M> builder() {
        return new Builder<>();
    }

    public static class Builder<M extends InternalDictionary> {

        private Class<M> modelClass;
        private EntityManager entityManager;
        private InternalDictionaryType internalDictionaryType;

        public Builder<M> modelClass(final Class<M> modelClass) {
            this.modelClass = modelClass;
            return this;
        }

        public Builder<M> entityManager(final EntityManager entityManager) {
            this.entityManager = entityManager;
            return this;
        }

        public Builder<M> internalDictionaryType(final InternalDictionaryType internalDictionaryType) {
            this.internalDictionaryType = internalDictionaryType;
            return this;
        }

        public DefaultInternalDictionaryJpaRepository<M> build() {
            Assert.notNull(this.modelClass, "modelClass cannot be null");
            Assert.notNull(this.entityManager, "entityManager cannot be null");
            return new DefaultInternalDictionaryJpaRepository<>(this.modelClass, this.entityManager, this.internalDictionaryType);
        }

    }
}
