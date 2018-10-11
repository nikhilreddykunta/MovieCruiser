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

@RunWith(SpringRunner.class)
@DataMongoTest
@WebAppConfiguration
public class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository ;

    Movie movie;
    List<Movie> list;
    @Before
    public void setUp() throws Exception {
        movie = new Movie("testId","testname","testurl",7.4,"2012","testcomment");
        list = new ArrayList<>();
        list.add(movie);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveMovieTest(){
        Movie expected= movieRepository.save(movie);
        Movie actual =movie;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findBymovieTitleTest() {
        movieRepository.save(movie);
        Movie expected= movieRepository.getByMovieTitle(movie.getMovieTitle());
        Movie actual =movie;
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void findAllTest(){
        movieRepository.save(movie);
        List<Movie> expected= movieRepository.findAll();
        List<Movie> actual =list;
        Assert.assertEquals(expected,actual);
    }

}
