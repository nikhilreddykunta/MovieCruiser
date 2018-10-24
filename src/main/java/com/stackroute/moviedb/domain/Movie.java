package com.stackroute.moviedb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    private String imdbId;
    private String movieTitle;
    private String posterUrl;
    private double rating;
    private String yearOfRelease;
    private String comments;


}
