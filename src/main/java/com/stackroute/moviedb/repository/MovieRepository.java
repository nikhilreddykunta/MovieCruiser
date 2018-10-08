package com.stackroute.moviedb.repository;

import com.stackroute.moviedb.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie,String> {

    public Movie getByMovieTitle(String movieTitle);
}
