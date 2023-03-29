package com.poc.dictionary.domain.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import static com.poc.dictionary.core.enumeration.InternalDictionaryType.Constants.APPEAL_REASON;

@Entity
@DiscriminatorValue(APPEAL_REASON)
public class AppealReasonDictionary extends InternalDictionary {
}
