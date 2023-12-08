package com.hexaware.movieticketbooking.dto;

public class MovieDTO {

    private String title;
    private String genre;
    private String director;
    private int duration;
    private double rating;

    public MovieDTO() {

    super();
    }

    public MovieDTO(String title, String genre, String director, int duration, double rating) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.duration = duration;
        this.rating = rating;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}