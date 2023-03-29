package com.poc.dictionary.domain.model;

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

}
