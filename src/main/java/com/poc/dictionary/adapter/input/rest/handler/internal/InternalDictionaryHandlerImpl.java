package com.poc.dictionary.adapter.input.rest.handler.internal;

import com.poc.dictionary.adapter.input.rest.converter.InternalDictionaryConverter;
import com.poc.dictionary.adapter.input.rest.data.InternalDictionaryDto;
import com.poc.dictionary.adapter.input.rest.handler.InternalDictionaryHandler;
import com.poc.dictionary.application.port.InternalDictionaryManager;
import com.poc.dictionary.core.enumeration.InternalDictionaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Component
public class InternalDictionaryHandlerImpl implements InternalDictionaryHandler {

    private final InternalDictionaryManager manager;
    private final InternalDictionaryConverter converter;

    @Autowired
    public InternalDictionaryHandlerImpl(final InternalDictionaryManager manager,
                                         final InternalDictionaryConverter converter) {
        this.manager = manager;
        this.converter = converter;
    }

    @Override
    @Transactional(readOnly = true)
    public List<InternalDictionaryDto> getAll(final InternalDictionaryType dictionaryType) {
        return manager.service(dictionaryType).loadAll().stream()
                .map(converter::convert)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public InternalDictionaryDto getById(final UUID id, final InternalDictionaryType dictionaryType) {
        return converter.convert(manager.service(dictionaryType).loadById(id));
    }

}
