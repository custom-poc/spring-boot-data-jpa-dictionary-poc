package com.poc.dictionary.core.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;

import static java.util.Arrays.stream;

public enum InternalDictionaryType {

    PROVIDER_APPEAL_REASON(Constants.PROVIDER_APPEAL_REASON),
    PROVIDER_APPEAL_VIOLATION_REASON(Constants.PROVIDER_APPEAL_VIOLATION_REASON),
    PROVIDER_APPEAL_REJECTION_REASON(Constants.PROVIDER_APPEAL_REJECTION_REASON);

    private final String discriminator;

    InternalDictionaryType(final String discriminator) {
        this.discriminator = discriminator;
    }

    @JsonCreator
    public static InternalDictionaryType valueByDiscriminatorOrName(final String source) {
        return stream(values())
                .filter(value -> value.discriminator().equals(source) || value.name().equals(source))
                .findAny()
                .orElse(null);
    }

    public String discriminator() {
        return discriminator;
    }

    public static final class Constants {

        public static final String PROVIDER_APPEAL_REASON = "provider-appeal-reason";
        public static final String PROVIDER_APPEAL_VIOLATION_REASON = "provider-appeal-violation-reason";
        public static final String PROVIDER_APPEAL_REJECTION_REASON = "provider-appeal-rejection-reason";

        private Constants() {
            // Suppresses default constructor
        }

    }

}
