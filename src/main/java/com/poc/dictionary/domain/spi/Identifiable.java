package com.poc.dictionary.domain.spi;

import org.springframework.data.domain.Persistable;

import java.util.Objects;
import java.util.UUID;

public interface Identifiable extends Persistable<UUID> {

    @Override
    default boolean isNew() {
        return Objects.isNull(getId());
    }

}
