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

import static com.poc.dictionary.core.spi.InternalBinaryOperator.first;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toUnmodifiableMap;

@Service
public class DefaultInternalDictionaryManager implements InternalDictionaryManager {

    private final Map<InternalDictionaryType, InternalDictionaryService<? extends InternalDictionary>> internalDictionaryServiceMap;

    @Autowired
    public <M extends InternalDictionary> DefaultInternalDictionaryManager(@NonNull final List<InternalDictionaryService<M>> services) {
        this.internalDictionaryServiceMap = services.stream()
                .collect(toUnmodifiableMap(InternalDictionaryService::dictionaryType, identity(), first()));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <M extends InternalDictionary> InternalDictionaryService<M> service(final InternalDictionaryType dictionaryType) {
        return (InternalDictionaryService<M>) internalDictionaryServiceMap.get(dictionaryType);
    }

}
