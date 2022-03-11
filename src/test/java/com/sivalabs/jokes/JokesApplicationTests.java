package com.sivalabs.jokes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class JokesApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldGetAllJokes() throws Exception {
        mockMvc.perform(
                get("/api/jokes"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.size()", is(3200)));
    }

    @Test
    void shouldGetJokeById() throws Exception {
        mockMvc.perform(
                        get("/api/jokes/1"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.body", containsString("blackjack dealer")));
    }

    @Test
    void shouldGetRandomJoke() throws Exception {
        mockMvc.perform(
                        get("/api/jokes/random"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.body", notNullValue()));
    }

}
