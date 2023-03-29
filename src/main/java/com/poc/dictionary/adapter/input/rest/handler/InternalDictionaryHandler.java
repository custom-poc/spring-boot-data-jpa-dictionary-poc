package com.poc.dictionary.adapter.input.rest.handler;

import com.poc.dictionary.adapter.input.rest.data.InternalDictionaryDto;
import com.poc.dictionary.core.enumeration.InternalDictionaryType;

import java.util.List;
import java.util.UUID;

public interface InternalDictionaryHandler {

    List<InternalDictionaryDto> getAll(InternalDictionaryType dictionaryType);

    InternalDictionaryDto getById(UUID id, InternalDictionaryType dictionaryType);

}
