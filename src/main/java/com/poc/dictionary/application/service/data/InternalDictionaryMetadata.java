package com.poc.dictionary.application.service.data;

import org.springframework.lang.NonNull;

public record InternalDictionaryMetadata(
        Boolean ordered
) {

    /* Builder */
    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Boolean ordered;

        public Builder ordered(final Boolean ordered) {
            this.ordered = ordered;
            return this;
        }

        public InternalDictionaryMetadata build() {
            return new InternalDictionaryMetadata(this.ordered);
        }

    }

}
