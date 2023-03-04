package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {

    private HashMap<String,Movie> movieMap;
    private HashMap<String,Director> directorMap;
    private HashMap<String, List<String>> movieDirectorMap;

    public MovieRepository() {
        this.movieMap = new HashMap<String,Movie>();
        this.directorMap = new HashMap<String,Director>();
        this.movieDirectorMap = new HashMap<String,List<String>>();
    }

    public void saveMovie(Movie movie)
    {
        movieMap.put(movie.getName(), movie);
    }
    public void saveDirector(Director director)
    {
        directorMap.put(director.getName(), director);
    }
    public void addPair(String movie,String director)
    {
        if(movieMap.containsKey(movie) && directorMap.containsKey(director))
        {
            movieMap.put(movie,movieMap.get(movie));
            directorMap.put(director,directorMap.get(director));
            List<String>currMovies=new ArrayList<>();
            if(movieDirectorMap.containsKey(director))
            {
                currMovies=movieDirectorMap.get(director);
            }
            currMovies.add(movie);
            movieDirectorMap.put(director,currMovies);
        }
    }

    public Movie findMovie(String movieName) {
        return movieMap.get(movieName);
    }

    public Director findDirector(String directorName) {
        return directorMap.get(directorName);
    }

    public List<String> findmovieByDirector(String directorName) {
        List<String>list=new ArrayList<>();
        if(movieDirectorMap.containsKey(directorName))
        {
            list=movieDirectorMap.get(directorName);
        }
        return list;
    }

    public List<String> getAllMovies() {
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirectorbyName(String directorName) {
        List<String>list=new ArrayList<>();
        if(movieDirectorMap.containsKey(directorName))
        {
            list=movieDirectorMap.get(directorName);
            for(String movie:list)
            {
                if(movieMap.containsKey(movie))
                {
                    movieMap.remove(movie);
                }
            }
            movieDirectorMap.remove(directorName);
        }
        if(directorMap.containsKey(directorName))
        {
            directorMap.remove(directorName);
        }
    }

    public void removeAllDirectors() {
        HashSet<String>movieSet=new HashSet<>();
        for(String director: movieDirectorMap.keySet()){
            for(String movie: movieDirectorMap.get(director)){
                movieSet.add(movie);
            }
        }

        for(String movie: movieSet) {
            if (movieMap.containsKey(movie)) {
                movieMap.remove(movie);
            }
        }
    }
}