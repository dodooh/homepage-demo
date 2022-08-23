package com.tera.homepage.model;


import lombok.*;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Media {
    private Integer id;
    private String title;
    private String description;
    private MediaAsset mediaAsset;
    private LocalDateTime startTime;
    private LocalDateTime expiredTime;
    private MediaType mediaType;
}
