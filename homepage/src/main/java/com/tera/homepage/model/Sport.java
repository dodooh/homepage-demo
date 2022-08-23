package com.tera.homepage.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
public class Sport extends Media{
    private String player;
   @Builder
    public Sport(Integer id, String title, String description, MediaAsset mediaAsset, LocalDateTime startTime, LocalDateTime expiredTime, MediaType mediaType, String player) {
        super(id, title, description, mediaAsset, startTime, expiredTime, mediaType);
        this.player = player;
    }
}
