package com.tera.homepage.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

public class Movie extends Media{
    private List<String> actors;
    private List<String> directors;

    @Builder

    public Movie(Integer id, String title, String description, MediaAsset mediaAsset, LocalDateTime startTime, LocalDateTime expiredTime, MediaType mediaType, List<String> actors, List<String> directors) {
        super(id, title, description, mediaAsset, startTime, expiredTime, mediaType);
        this.actors = actors;
        this.directors = directors;
    }
}
