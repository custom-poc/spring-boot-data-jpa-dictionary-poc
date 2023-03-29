package com.poc.dictionary.adapter.output.repository;

import com.poc.dictionary.domain.model.AppealReasonDictionary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppealReasonDictionaryRepository extends JpaRepository<AppealReasonDictionary, UUID> {
}
