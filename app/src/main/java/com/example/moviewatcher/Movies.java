package com.example.moviewatcher;

public class Movies {
    //TODO fields to be used with api. Are they complete?
    private String imdbId;
    private String title;
    private String plot;
    private String yearOfRelease;
    private String type;
    private int episode;
    private int season;
    private String poster;


    public Movies(String imdbId, String title, String yearOfRelease, String type, String poster) {
        this.imdbId = imdbId;
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.type = type;
        this.poster = poster;
    }

    public String getimdbId() {
        return imdbId;
    }

    public void setimdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
