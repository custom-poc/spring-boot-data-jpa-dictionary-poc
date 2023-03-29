package com.poc.dictionary.domain.base;

import com.poc.dictionary.domain.spi.Identifiable;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.UUID;

@MappedSuperclass
public abstract class BaseModel implements Identifiable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

}
