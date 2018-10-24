package com.stackroute.moviedb.repository;

import com.stackroute.moviedb.domain.Movie;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataMongoTest
@WebAppConfiguration
public class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository ;

    Movie movie;
    ArrayList<Movie> list;
    @Before
    public void setUp() throws Exception {
        movie = new Movie("testId","testname","testurl",7.4,"2012","testcomments");
        list = new ArrayList<>();
        list.add(movie);
    }

    @After
    public void tearDown() throws Exception {
        movieRepository.deleteAll();
    }

    @Test
    public void saveMovieTest(){
        Movie expected= movieRepository.save(movie);
        Movie actual =movie;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testSaveMovieFailure(){
        Movie testMovie = new Movie("tt0061729","Spiderman",
                "http://ia.media-imdb.com/images/M/MV5BMTQ0ODc4MDk4Nl5BMl5BanBnXkFtZTcwMTEzNzgzNA@@._V1_SX300.jpg",
                8.2,"2011","good");
        movieRepository.save(movie);
        Movie fetchMovie = movieRepository.findById(movie.getImdbId()).get();
        Assert.assertNotSame(testMovie.getImdbId(), fetchMovie.getImdbId());
    }


    @Test
    public void findBymovieTitleTest() {
        movieRepository.save(movie);
        Movie expected= movieRepository.getByMovieTitle(movie.getMovieTitle());
        Movie  actual =movie;
        Assert.assertEquals(expected.getMovieTitle(),actual.getMovieTitle());
    }

    @Test
    public void findAllTest(){
        movieRepository.save(movie);
        List<Movie> expected= movieRepository.findAll();
        ArrayList<Movie> actual =list;
        Assert.assertEquals(expected.get(0).toString(),actual.get(0).toString());
    }

    @Test
    public void testDeleteMovie(){
        movieRepository.save(movie);
        movieRepository.delete(movie);
        Assert.assertEquals(Optional.empty(),movieRepository.findById(movie.getImdbId()));
    }
}
