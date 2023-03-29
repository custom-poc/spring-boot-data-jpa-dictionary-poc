package com.poc.dictionary.adapter.input.rest.controller;

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

import static com.poc.dictionary.core.enumeration.InternalDictionaryType.APPEAL_REASON;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:fixture/internal_dictionary_insert.sql"})
@Sql(executionPhase = AFTER_TEST_METHOD, scripts = {"classpath:fixture/internal_dictionary_truncate.sql"})
class InternalDictionaryControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getByIdTest() throws Exception {
        // Given
        final UUID id = UUID.fromString("303c22a6-403d-49f1-84f6-fd3290f80cad");
        // Expected
        final MockHttpServletRequestBuilder get = MockMvcRequestBuilders
                .get("/dictionaries/{id}/{dictionaryType}", id, APPEAL_REASON.discriminator())
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
                .get("/dictionaries/{dictionaryType}", APPEAL_REASON.discriminator())
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(get).andExpectAll(
                MockMvcResultMatchers.status().isOk(),
                MockMvcResultMatchers.jsonPath("$.size()").value(2)
        );
    }

}
