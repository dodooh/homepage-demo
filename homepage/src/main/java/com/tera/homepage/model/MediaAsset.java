package com.tera.homepage.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MediaAsset {
    private Integer id;
    private Integer mediaId;
    private String bannerUrl;
    private String posterUrl;
    private String thumbnailUrl;
}
