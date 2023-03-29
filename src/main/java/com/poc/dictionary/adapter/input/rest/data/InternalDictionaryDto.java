package com.poc.dictionary.adapter.input.rest.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import java.util.UUID;

public record InternalDictionaryDto(
        @JsonProperty("id") UUID id,
        @JsonProperty("priority") Long priority,
        @JsonProperty("caption") String caption,
        @JsonProperty("description") String description
) {

    /* Builder */
    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private UUID id;
        private Long priority;
        private String caption;
        private String description;

        public Builder id(final UUID id) {
            this.id = id;
            return this;
        }

        public Builder priority(final Long priority) {
            this.priority = priority;
            return this;
        }

        public Builder caption(final String caption) {
            this.caption = caption;
            return this;
        }

        public Builder description(final String description) {
            this.description = description;
            return this;
        }

        @NonNull
        public InternalDictionaryDto build() {
            return new InternalDictionaryDto(this.id, this.priority, this.caption, this.description);
        }

    }

}
