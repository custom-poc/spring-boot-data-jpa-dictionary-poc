package com.poc.dictionary.application.port;

import com.poc.dictionary.core.enumeration.InternalDictionaryType;
import com.poc.dictionary.domain.model.InternalDictionary;

import java.util.List;
import java.util.UUID;

public interface InternalDictionaryService<M extends InternalDictionary> {

    List<M> loadAll();

    M saveOne(M model);

    M loadById(UUID id);

    Boolean deleteById(UUID id);

    InternalDictionaryType internalDictionaryType();

}
