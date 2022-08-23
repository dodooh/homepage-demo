package com.tera.homepage.service;

import com.tera.homepage.model.Item;
import com.tera.homepage.model.Media;
import com.tera.homepage.model.MediaType;

import java.util.List;

public interface SearchService {

    List<Media> fetchAllMediaByType(MediaType mediaType);
}
