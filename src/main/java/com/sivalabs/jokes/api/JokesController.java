package com.sivalabs.jokes.api;

import com.sivalabs.jokes.domain.Joke;
import com.sivalabs.jokes.domain.JokesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jokes")
@RequiredArgsConstructor
class JokesController {
    private final JokesService jokesService;

    @GetMapping()
    List<Joke> findAllJokes() {
        return jokesService.findAll();
    }

    @GetMapping("/{id}")
    Joke findById(@PathVariable Long id) {
        return jokesService.findById(id);
    }

    @GetMapping("/random")
    Joke findRandomJoke() {
        return jokesService.findRandomJoke();
    }

}
