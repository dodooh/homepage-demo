package com.tera.homepage.service.impl;

import com.tera.homepage.model.Media;
import com.tera.homepage.model.MediaType;
import com.tera.homepage.repository.ElasticsearchIndexRepository;
import com.tera.homepage.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private ElasticsearchIndexRepository elasticsearchIndexRepository;

    @Override
    public List<Media> fetchAllMediaByType(MediaType mediaType) {
        return elasticsearchIndexRepository.findMediaByMediaType(mediaType);
    }
}
