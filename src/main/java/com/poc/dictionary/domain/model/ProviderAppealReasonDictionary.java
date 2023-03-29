package com.poc.dictionary.domain.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import static com.poc.dictionary.core.enumeration.InternalDictionaryType.Constants.PROVIDER_APPEAL_REASON;

@Entity
@DiscriminatorValue(PROVIDER_APPEAL_REASON)
public class ProviderAppealReasonDictionary extends InternalDictionary {
}
