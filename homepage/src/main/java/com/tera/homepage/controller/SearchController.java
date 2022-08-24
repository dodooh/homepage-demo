package com.tera.homepage.controller;

import com.tera.homepage.model.Media;
import com.tera.homepage.model.MediaType;
import com.tera.homepage.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/homepage")
public class SearchController {

    private SearchService searchService;

    @Autowired
    public SearchController(final SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("top")
    public List<Media> fetchAllMediaByType(@RequestParam("mediaType") MediaType mediaType) {
        return searchService.fetchAllMediaByType(mediaType);
    }
}
