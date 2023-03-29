package com.poc.dictionary.adapter.input.rest.converter;

import com.poc.dictionary.core.enumeration.InternalDictionaryType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class StringToInternalDictionaryTypeConverter implements Converter<String, InternalDictionaryType> {

    @Override
    public InternalDictionaryType convert(@NonNull final String source) {
        return InternalDictionaryType.valueByDiscriminatorOrName(source);
    }

}
