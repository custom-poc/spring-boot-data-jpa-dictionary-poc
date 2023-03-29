package com.poc.dictionary.adapter.output.repository;

import com.poc.dictionary.domain.model.ProviderAppealReasonDictionary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProviderAppealReasonDictionaryRepository extends JpaRepository<ProviderAppealReasonDictionary, UUID> {
}
