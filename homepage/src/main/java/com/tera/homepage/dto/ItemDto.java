package com.tera.homepage.dto;

import com.tera.homepage.model.MediaType;
import com.tera.homepage.model.Platform;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemDto {
    private Integer id;
    private MediaType mediaType;
    private LocalDateTime startTime;
    private LocalDateTime expiredTime;
    private String title;
    private String description;
    private List<String> actors;
    private List<String> directors;
    private Integer channelId;
    private List<String> player;
    private Platform platform;
}
