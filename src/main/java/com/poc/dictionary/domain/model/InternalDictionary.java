package com.poc.dictionary.domain.model;

import com.poc.dictionary.domain.base.BaseModel;
import jakarta.persistence.*;

import java.util.Optional;

import static jakarta.persistence.InheritanceType.SINGLE_TABLE;

@Entity
@Table(name = "internal_dictionary")
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator")
public class InternalDictionary extends BaseModel {

    @Column(name = "priority", nullable = false)
    private Long priority;
    @Column(name = "caption", nullable = false)
    private String caption;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "relation_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private InternalDictionary relation;

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Optional<InternalDictionary> getRelation() {
        return Optional.ofNullable(relation);
    }

    public void setRelation(InternalDictionary relation) {
        this.relation = relation;
    }

}
