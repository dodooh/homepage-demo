package com.tera.homepage.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class LinkPlay{
    private Integer id;
    private Integer mediaId;
    private String url;
    private Platform platform;

}
