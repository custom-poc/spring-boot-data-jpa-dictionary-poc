package com.poc.dictionary.adapter.input.rest.controller;

import core.base.BasePostgreSqlIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static com.poc.dictionary.core.enumeration.InternalDictionaryType.*;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:fixture/internal_dictionary_insert.sql"})
@Sql(executionPhase = AFTER_TEST_METHOD, scripts = {"classpath:fixture/internal_dictionary_truncate.sql"})
class InternalDictionaryControllerIntegrationTests extends BasePostgreSqlIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getByIdTest() throws Exception {
        // Given
        final UUID id = UUID.fromString("303c22a6-403d-49f1-84f6-fd3290f80cad");
        // Expected
        final MockHttpServletRequestBuilder get = MockMvcRequestBuilders
                .get("/dictionaries/{id}/{dictionaryType}", id, PROVIDER_APPEAL_REASON.discriminator())
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(get).andExpectAll(
                MockMvcResultMatchers.status().isOk(),
                MockMvcResultMatchers.jsonPath("$.id").value(id.toString())
        );
    }

    @Test
    void getAllTest() throws Exception {
        // Expected
        final MockHttpServletRequestBuilder get = MockMvcRequestBuilders
                .get("/dictionaries/{dictionaryType}", PROVIDER_APPEAL_REASON.discriminator())
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(get).andExpectAll(
                MockMvcResultMatchers.status().isOk(),
                MockMvcResultMatchers.jsonPath("$.size()").value(2)
        );
    }

    @Test
    void getAllRejectionsByRelationIdTest() throws Exception {
        // Given
        final String dictionaryType = PROVIDER_APPEAL_REJECTION_REASON.discriminator();
        final UUID relationId = UUID.fromString("303c22a6-403d-49f1-84f6-fd3290f80cad");
        // Expected
        final MockHttpServletRequestBuilder get = MockMvcRequestBuilders
                .get("/dictionaries/{dictionaryType}/relation/{relationId}", dictionaryType, relationId)
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(get).andExpectAll(
                MockMvcResultMatchers.status().isOk(),
                MockMvcResultMatchers.jsonPath("$.size()").value(2),
                MockMvcResultMatchers.jsonPath("$[0].id").value("2ffb0c1a-4c65-4200-87f1-c39802f7f79e"),
                MockMvcResultMatchers.jsonPath("$[1].id").value("bf9a788c-d6a8-47e7-8fb1-e7c7fedb0e4f")
        );
    }

    @Test
    void getAllViolationsByRelationIdTest() throws Exception {
        // Given
        final String dictionaryType = PROVIDER_APPEAL_VIOLATION_REASON.discriminator();
        final UUID relationId = UUID.fromString("303c22a6-403d-49f1-84f6-fd3290f80cad");
        // Expected
        final MockHttpServletRequestBuilder get = MockMvcRequestBuilders
                .get("/dictionaries/{dictionaryType}/relation/{relationId}", dictionaryType, relationId)
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(get).andExpectAll(
                MockMvcResultMatchers.status().isOk(),
                MockMvcResultMatchers.jsonPath("$.size()").value(2),
                MockMvcResultMatchers.jsonPath("$[0].id").value("46d346aa-9290-4a1b-81dc-171e55319eef"),
                MockMvcResultMatchers.jsonPath("$[1].id").value("7b8d6333-35ad-4384-a97f-914973805438")
        );
    }

}
