package com.poc.dictionary.adapter.input.rest.converter;

import com.poc.dictionary.adapter.input.rest.data.InternalDictionaryDto;
import com.poc.dictionary.domain.model.InternalDictionary;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class InternalDictionaryConverter {

    @NonNull
    public <M extends InternalDictionary> InternalDictionaryDto convert(@NonNull final M source) {
        return InternalDictionaryDto.builder()
                .description(source.getDescription().orElse(null))
                .priority(source.getPriority())
                .caption(source.getCaption())
                .id(source.getId())
                .build();
    }

}
