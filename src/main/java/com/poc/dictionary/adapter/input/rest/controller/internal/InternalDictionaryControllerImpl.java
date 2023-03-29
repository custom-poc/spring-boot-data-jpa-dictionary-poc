package com.poc.dictionary.adapter.input.rest.controller.internal;

import com.poc.dictionary.adapter.input.rest.controller.InternalDictionaryController;
import com.poc.dictionary.adapter.input.rest.data.InternalDictionaryDto;
import com.poc.dictionary.adapter.input.rest.handler.InternalDictionaryHandler;
import com.poc.dictionary.core.enumeration.InternalDictionaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/dictionaries", produces = APPLICATION_JSON_VALUE)
public class InternalDictionaryControllerImpl implements InternalDictionaryController {

    private final InternalDictionaryHandler handler;

    @Autowired
    public InternalDictionaryControllerImpl(final InternalDictionaryHandler handler) {
        this.handler = handler;
    }

    @Override
    @GetMapping("/{id}/{dictionaryType}")
    public InternalDictionaryDto getById(@PathVariable final UUID id,
                                         @PathVariable final InternalDictionaryType dictionaryType) {
        return handler.getById(id, dictionaryType);
    }

    @Override
    @GetMapping(path = "/{dictionaryType}")
    public List<InternalDictionaryDto> getAll(@PathVariable final InternalDictionaryType dictionaryType) {
        return handler.getAll(dictionaryType);
    }

}
