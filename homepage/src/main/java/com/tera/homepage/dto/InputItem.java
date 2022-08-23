package com.tera.homepage.dto;

import com.tera.homepage.model.LinkPlay;
import com.tera.homepage.model.MediaAsset;
import com.tera.homepage.model.MediaType;
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
public class InputItem {
    private Integer id;
    private String title;
    private String description;
    private MediaAsset mediaAsset;
    private LocalDateTime startTime;
    private LocalDateTime expiredTime;
    private MediaType mediaType;
    private List<LinkPlay> linkPlay;

    private List<String> actors;
    private List<String> directors;
    private Integer channelId;
    private String player;

}

