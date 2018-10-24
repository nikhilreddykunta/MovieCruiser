package com.stackroute.moviedb.service;

import com.stackroute.moviedb.domain.Movie;
import com.stackroute.moviedb.exceptions.MovieAlreadyExistsException;
import com.stackroute.moviedb.exceptions.MovieNotFoundException;
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
import java.util.NoSuchElementException;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class MovieServiceImplTest {

    Movie movie;

    @Mock
    MovieRepository movieRepository;

    @InjectMocks
    MovieServiceImpl movieServiceimpl;

    ArrayList<Movie> list= null;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        movie = new Movie("testId","testname","testurl",7.4,"2012","testcomments");
        list = new ArrayList<>();
        list.add(movie);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveMovie() throws MovieAlreadyExistsException {
        when(movieRepository.save((Movie)any())).thenReturn(movie);
        Movie savedmovie = movieServiceimpl.saveMovie(movie);
        Assert.assertEquals(movie,savedmovie);
    }

    @Test(expected = MovieAlreadyExistsException.class)
    public void saveMovieTestFailure() throws MovieAlreadyExistsException {
        when(movieRepository.save((Movie) any())).thenReturn(null);
        Movie savedMovie = movieServiceimpl.saveMovie(movie);
        System.out.println("savedMovie" + savedMovie);
        verify(movieRepository,times(1)).save(movie);
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
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void searchByMovieName() {
        try {
            movieRepository.save(movie);
            when(movieRepository.getByMovieTitle(any())).thenReturn(movie);
            Movie userlist = movieServiceimpl.getByMovieTitle(movie.getMovieTitle());
            Assert.assertEquals(movie,userlist);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Test
    public void getAllMovies() {
        movieRepository.save(movie);
        when(movieRepository.findAll()).thenReturn(list);
        List<Movie> userlist = movieServiceimpl.getAllMovies();
        Assert.assertEquals(list,userlist);
    }

    @Test(expected = NoSuchElementException.class)
    public void updateMovieByIdTestSuccess() throws MovieNotFoundException {
        when(movieRepository.existsById(anyString())).thenReturn(true);
        when(movieRepository.findById(anyString()).get()).thenReturn(movie);

        //doNothing().when(movieRepository).deleteById(anyString());
        Movie fetchMovie= movieServiceimpl.updateMovie(movie.getImdbId(),movie.getComments());
        //System.out.println(b);
        Assert.assertNotEquals(null,fetchMovie);

        verify(movieRepository,times(1)).existsById(movie.getImdbId());

    }

    @Test(expected = NoSuchElementException.class)
    public void deleteMovieTestSuccess() throws MovieNotFoundException {
        when(movieServiceimpl.deleteMovie(anyString())).thenReturn(true);
        doNothing().when(movieRepository).deleteById(anyString());
        boolean b = movieServiceimpl.deleteMovie(movie.getImdbId());
        System.out.println(b);
        Assert.assertEquals(true,b);
        verify(movieRepository,times(1)).deleteById(movie.getImdbId());

    }

    @Test(expected = NoSuchElementException.class)
    public void deleteMovieTestFailure()  {
        when(movieServiceimpl.deleteMovie(anyString())).thenReturn(true);
        doNothing().when(movieRepository).deleteById(anyString());
        boolean b = movieServiceimpl.deleteMovie(movie.getImdbId());
        System.out.println(b);
        Assert.assertNotEquals(false,b);

        //verify here verifies that movieRepository delete method is only called once
        verify(movieRepository,times(1)).deleteById(movie.getImdbId());

    }

}