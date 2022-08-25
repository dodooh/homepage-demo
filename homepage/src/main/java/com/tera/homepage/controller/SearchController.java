package com.tera.homepage.controller;

import com.tera.homepage.model.Media;
import com.tera.homepage.model.MediaType;
import com.tera.homepage.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/homepage")
@CrossOrigin
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
