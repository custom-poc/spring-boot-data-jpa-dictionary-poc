package com.poc.dictionary.application.service;

import com.poc.dictionary.application.port.InternalDictionaryManager;
import com.poc.dictionary.application.port.InternalDictionaryService;
import com.poc.dictionary.core.enumeration.InternalDictionaryType;
import com.poc.dictionary.domain.model.InternalDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class DefaultInternalDictionaryManager implements InternalDictionaryManager {

    private final Map<InternalDictionaryType, InternalDictionaryService<? extends InternalDictionary>> internalDictionaryServiceMap;

    @Autowired
    public <M extends InternalDictionary> DefaultInternalDictionaryManager(@NonNull final List<InternalDictionaryService<M>> services) {
        this.internalDictionaryServiceMap = services.stream()
                .collect(Collectors.toMap(InternalDictionaryService::internalDictionaryType, Function.identity()));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <M extends InternalDictionary> InternalDictionaryService<M> service(final InternalDictionaryType dictionaryType) {
        return (InternalDictionaryService<M>) internalDictionaryServiceMap.get(dictionaryType);
    }

}
