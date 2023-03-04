package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("movies")

public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie)
    {
        movieService.addMovie(movie);
        return new ResponseEntity<>("new movie added sucessfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director)
    {
        movieService.addDirector(director);
        return new ResponseEntity<>("new director added sucessfully",HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("id1") String movieName ,@RequestParam("id2") String directorName)
    {
        movieService.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity<>("Pair added Sucessfully",HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("id") String movieName)
    {
        Movie movies=movieService.getMovieByName(movieName);
        return new ResponseEntity<>(movies,HttpStatus.FOUND);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("id") String directorName)
    {
        Director dir=movieService.getDirectorByName(directorName);
        return new ResponseEntity<Director>(dir,HttpStatus.FOUND);
    }

    @GetMapping("/get-movies-by-director-name{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("id") String direectorName)
    {
        List<String>list=movieService.getMoviesByDirectorName(direectorName);
        return new ResponseEntity<>(list,HttpStatus.FOUND);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies()
    {
        List<String>movies=movieService.findAllMovies();
        return new ResponseEntity<>(movies,HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("id") String directorName)
    {
        movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>("director deleted Sucesfully",HttpStatus.GONE);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors()
    {
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("all directors and associated movies deleted",HttpStatus.GONE);
    }





}