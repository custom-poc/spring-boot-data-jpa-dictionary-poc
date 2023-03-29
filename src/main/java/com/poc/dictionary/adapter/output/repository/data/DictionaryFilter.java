package com.poc.dictionary.adapter.output.repository.data;

import java.util.Optional;

@SuppressWarnings("unused")
public record DictionaryFilter(
        String caption
) {
    public Optional<String> getCaption() {
        return Optional.ofNullable(caption());
    }
}
