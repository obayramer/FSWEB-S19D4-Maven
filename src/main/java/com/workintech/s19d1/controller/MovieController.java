package com.workintech.s19d1.controller;

import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.MovieService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
@RestController
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;
    @GetMapping
    public List<Movie> getAll() {
        List<Movie> movieList = movieService.findAll();
        List<Movie> collected = movieList.stream().map(movie -> {
            movie.setActors(movie.getActors());
            return movie;
        }).collect(Collectors.toList());
        return collected;
    }
}