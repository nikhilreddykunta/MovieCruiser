package com.stackroute.moviedb.service;

import com.stackroute.moviedb.domain.Movie;
import com.stackroute.moviedb.exceptions.MovieAlreadyExistsException;
import com.stackroute.moviedb.repository.MovieRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class MovieServiceImplTest {

    Movie movie;
    @Mock
    MovieRepository movieRepository;
    @InjectMocks
    MovieServiceImpl movieServiceimpl;
    List<Movie> list= null;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        movie = new Movie("testId", "testname", "testurl", 7.4, "2012", "testcomments");
        list = new ArrayList<>();
        list.add(movie);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveMovie() throws MovieAlreadyExistsException {
        when(movieRepository.save((Movie)any())).thenReturn(movie);
        Movie savedmovie = movieRepository.save(movie);
        Assert.assertEquals(movie,savedmovie);
    }

    @Test
    public void searchMovieById() {
        try {
            movieRepository.save(movie);
            when(movieRepository.findById(any()).get()).thenReturn(movie);
            Movie savedmovie = movieServiceimpl.getMovie(movie.getImdbId());
            Assert.assertEquals(savedmovie, movie);
        }
        catch (Exception ex){

        }
    }

    @Test
    public void searchByMovieName() {
        movieRepository.save(movie);
        //when(movieRepository.getByMovieTitle(any())).thenReturn(list);
        List<Movie> userlist = movieServiceimpl.getByMovieTitle(movie.getMovieTitle());
        try{
            responseEntity = new ResponseEntity<Movie>(movieService.getByMovieTitle(movieTitle) , HttpStatus.OK);
        }catch (MovieNotFoundException e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        Assert.assertEquals(list,userlist);
    }

    @Test
    public void getAllMovies() {
        movieRepository.save(movie);
        when(movieRepository.findAll()).thenReturn(list);
        List<Movie> userlist = movieServiceimpl.getAllMovies();
        Assert.assertEquals(list,userlist);
    }
}
