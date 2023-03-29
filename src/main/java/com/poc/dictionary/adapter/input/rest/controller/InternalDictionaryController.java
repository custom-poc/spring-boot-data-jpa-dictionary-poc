package com.poc.dictionary.adapter.input.rest.controller;

import com.poc.dictionary.adapter.input.rest.data.InternalDictionaryDto;
import com.poc.dictionary.core.enumeration.InternalDictionaryType;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("unused")
public interface InternalDictionaryController {

    InternalDictionaryDto getById(UUID id,
                                  InternalDictionaryType dictionaryType);

    List<InternalDictionaryDto> getAll(InternalDictionaryType dictionaryType);

}
