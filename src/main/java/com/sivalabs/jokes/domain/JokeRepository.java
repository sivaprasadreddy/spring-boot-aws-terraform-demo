package com.sivalabs.jokes.domain;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
class JokeRepository {
    private final Map<Long, Joke> JOKES_DB = new HashMap<>();

    Joke save(Joke joke) {
        JOKES_DB.put(joke.getId(), joke);
        return joke;
    }

    Joke findById(Long id) {
        return JOKES_DB.get(id);
    }

    List<Joke> findAll() {
        return List.copyOf(JOKES_DB.values());
    }

    List<Long> findAllIds() {
        return JOKES_DB.values().stream().map(Joke::getId).collect(Collectors.toList());
    }
}
