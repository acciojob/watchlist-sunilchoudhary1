package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie)
    {
        movieRepository.saveMovie(movie);
    }

    public void addDirector(Director director)
    {
        movieRepository.saveDirector(director);
    }

    public void addMovieDirectorPair(String movieName,String directorName)
    {
        movieRepository.addPair(movieName,directorName);
    }

    public Movie getMovieByName(String movieName)
    {
        return movieRepository.findMovie(movieName);
    }

    public Director getDirectorByName(String directorName)
    {
        return movieRepository.findDirector(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName)
    {
        return movieRepository.findmovieByDirector(directorName);
    }

    public List<String> findAllMovies()
    {
        return movieRepository.getAllMovies();
    }
    public void deleteDirectorByName(String directorName)
    {
        movieRepository.deleteDirectorbyName(directorName);
    }
    public void deleteAllDirectors()
    {
        movieRepository.removeAllDirectors();
    }

}