package com.stackroute.moviedb.service;

import com.stackroute.moviedb.domain.Movie;
import com.stackroute.moviedb.exceptions.MovieAlreadyExistsException;
import com.stackroute.moviedb.exceptions.MovieNotFoundException;

import java.util.List;

public interface MovieService {

    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException;

    public List<Movie> getAllMovies();

    public Movie updateMovie(String id,String comments);

    public void deleteMovie(String id);

    public Movie getMovie(String id);

    public Movie getByMovieTitle(String movieTitle) throws MovieNotFoundException;
}
