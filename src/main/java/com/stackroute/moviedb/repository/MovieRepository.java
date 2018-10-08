package com.stackroute.moviedb.repository;

import com.stackroute.moviedb.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,String>{

    public Movie getByMovieTitle(String movieTitle);
}
