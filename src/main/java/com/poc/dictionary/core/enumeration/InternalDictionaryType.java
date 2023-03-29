package com.poc.dictionary.core.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;

import static java.util.Arrays.stream;

public enum InternalDictionaryType {

    APPEAL_REASON(Constants.APPEAL_REASON),
    PROVIDER_REGISTRATION_REJECTION_REASON(Constants.PROVIDER_REGISTRATION_REJECTION_REASON);

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

        public static final String APPEAL_REASON = "appeal-reason";
        public static final String PROVIDER_REGISTRATION_REJECTION_REASON = "provider-registration-rejection-reason";

        private Constants() {
            // Suppresses default constructor
        }

    }

}
