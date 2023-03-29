package com.poc.dictionary.application.port;

import com.poc.dictionary.core.enumeration.InternalDictionaryType;
import com.poc.dictionary.domain.model.InternalDictionary;

public interface InternalDictionaryManager {

    <M extends InternalDictionary> InternalDictionaryService<M> service(InternalDictionaryType dictionaryType);

}
