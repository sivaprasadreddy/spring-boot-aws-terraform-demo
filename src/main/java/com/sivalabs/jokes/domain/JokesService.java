package com.sivalabs.jokes.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class JokesService {
    private final JokeRepository repository;

    public Joke save(Joke joke) {
        return repository.save(joke);
    }

    public Joke findById(Long id) {
        return repository.findById(id);
    }

    public List<Joke> findAll() {
        return repository.findAll();
    }

    public Joke findRandomJoke() {
        Random random = new Random();
        final List<Long> ids = repository.findAllIds();
        return findById(ids.get(random.nextInt(ids.size())));
    }
}
