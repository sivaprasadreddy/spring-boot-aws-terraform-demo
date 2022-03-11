package com.sivalabs.jokes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sivalabs.jokes.domain.Joke;
import com.sivalabs.jokes.domain.JokesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {
    private static final String jokesFile = "/data/jokes.json";
    private final JokesService jokesService;
    private final ObjectMapper objectMapper;

    @Override
    public void run(String... args) throws Exception {
        ClassPathResource resource = new ClassPathResource(jokesFile);
        List<Joke> jokes = objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {});
        jokes.stream().filter(joke -> StringUtils.hasText(joke.getBody())).forEach(jokesService::save);
        log.info("Data initialized successfully");
    }
}
