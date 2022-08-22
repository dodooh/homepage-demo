package com.tera.homepage.service;

import com.tera.homepage.model.Media;
import com.tera.homepage.model.MediaType;
import com.tera.homepage.model.Movie;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    private static final String HOMEPAGE_INDEX = "media";

    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    public SearchService(final ElasticsearchOperations elasticsearchOperations) {
        super();
        this.elasticsearchOperations = elasticsearchOperations;
    }


    public List<Media> fetchAllMediaByType(MediaType mediaType) {
        QueryBuilder queryBuilder = QueryBuilders.termQuery("mediaType", mediaType.toString());
        Query searchQuery = new NativeSearchQueryBuilder()
                .withFilter(queryBuilder)
                .withPageable(PageRequest.of(0, 10)).build();
        SearchHits<Media> searchHits = elasticsearchOperations.search(searchQuery, Media.class, IndexCoordinates.of(HOMEPAGE_INDEX));
        List<Media> moviesMatch = new ArrayList<>();
        searchHits.forEach(item -> moviesMatch.add(item.getContent()));

        return moviesMatch;
    }
}
