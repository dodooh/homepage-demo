package com.tera.homepage.service;

import com.tera.homepage.model.Item;
import com.tera.homepage.model.Media;
import com.tera.homepage.model.MediaType;
<<<<<<< HEAD
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;
=======
>>>>>>> d75fb02 (update create + search)

import java.util.List;

public interface SearchService {

    List<Media> fetchAllMediaByType(MediaType mediaType);
}
