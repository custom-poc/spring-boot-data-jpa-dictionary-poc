package com.poc.dictionary.domain.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import static com.poc.dictionary.core.enumeration.InternalDictionaryType.Constants.PROVIDER_APPEAL_REJECTION_REASON;

@Entity
@DiscriminatorValue(PROVIDER_APPEAL_REJECTION_REASON)
public class ProviderAppealRejectionReasonDictionary extends InternalDictionary {
}
