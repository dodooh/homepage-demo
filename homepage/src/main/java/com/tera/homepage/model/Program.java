package com.tera.homepage.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Program extends Media {
    private Integer channel_id;
    @Builder
    public Program(Integer id, String title, String description, MediaAsset mediaAsset, LocalDateTime startTime, LocalDateTime expiredTime, Integer channel_id) {
        super(id, title, description, mediaAsset, startTime, expiredTime);
        this.channel_id = channel_id;
    }
}
