package com.tera.homepage.dto;


import com.tera.homepage.model.MediaType;
import com.tera.homepage.model.Platform;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemQuery {
    private Integer id;
    private MediaType mediaType;
    private Platform platform;
}
