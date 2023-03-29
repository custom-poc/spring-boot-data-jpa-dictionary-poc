package com.poc.dictionary.adapter.output.repository;

import com.poc.dictionary.core.enumeration.InternalDictionaryType;
import com.poc.dictionary.domain.model.InternalDictionary;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InternalDictionaryJpaRepository<M extends InternalDictionary> {

    List<M> findAll();

    M saveOne(M model);

    Boolean deleteById(UUID id);

    Optional<M> findById(UUID id);

    List<M> findAllByRelationId(UUID relationId);

    InternalDictionaryType internalDictionaryType();

}
