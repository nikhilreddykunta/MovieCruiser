package com.stackroute.moviedb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
public class Movie {

    @Id
    private String imdbId;
    private String movieTitle;
    private String posterUrl;
    private double rating;
    private String yearOfRelease;
    private String comments;

    public Movie(String imdbId, String movieTitle, String posterUrl, double rating, String yearOfRelease, String comments) {
        this.imdbId = imdbId;
        this.movieTitle = movieTitle;
        this.posterUrl = posterUrl;
        this.rating = rating;
        this.yearOfRelease = yearOfRelease;
        this.comments = comments;
    }



    public Movie() {
    }


    @Override
    public String toString() {
        return "Movie{" +
                "imdbId='" + imdbId + '\'' +
                ", movieTitle='" + movieTitle + '\'' +
                ", posterUrl='" + posterUrl + '\'' +
                ", rating=" + rating +
                ", yearOfRelease='" + yearOfRelease + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setPosterUrl(String posterUrl) { this.posterUrl = posterUrl; }

    public String getPosterUrl() {
        return posterUrl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getComments() { return comments; }

    public void setComments(String comments) { this.comments = comments; }
}
