package com.tera.homepage.repository;

import com.tera.homepage.model.Media;
import com.tera.homepage.model.MediaType;

import java.util.List;

public interface ElasticsearchIndexRepository {
    boolean saveMedia(Media media);

    List<Media> findMediaByMediaType(MediaType mediaType);
}
