package com.stackroute.moviedb.service;

import com.stackroute.moviedb.domain.Movie;
import com.stackroute.moviedb.exceptions.MovieAlreadyExistsException;
import com.stackroute.moviedb.exceptions.MovieNotFoundException;
import com.stackroute.moviedb.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
        if(movieRepository.existsById(movie.getImdbId())) {
            throw new MovieAlreadyExistsException("Movie already exists");
        }
        Movie savedMovie = movieRepository.save(movie);

        if(savedMovie == null){
            throw new MovieAlreadyExistsException("Movie already exists");
        }
        return savedMovie;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }


    @Override
    public Movie updateMovie(String id, String comments) {
        Movie updatedMovie  = movieRepository.findById(id).get();
        updatedMovie.setComments(comments);
        return updatedMovie;
    }

    @Override
    public void deleteMovie(String id) {
        movieRepository.delete(movieRepository.findById(id).get());
    }

    @Override
    public Movie getMovie(String id) {
        final Movie movie = movieRepository.findById(id).get();
        return movie;
    }

    @Override
    public Movie getByMovieTitle(String movieTitle) throws MovieNotFoundException {
        Movie movie = movieRepository.getByMovieTitle(movieTitle);

        if(movie == null){
            throw new MovieNotFoundException("movie not found");
        }
        return movie;
    }
}
