package com.sivalabs.jokes.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Joke {
    private Long id;
    private String category;
    private String body;
    private double rating;
}
