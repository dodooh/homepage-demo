package com.tera.homepage.repository.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.Result;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.RangeQuery;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.json.JsonData;
import com.tera.homepage.model.Media;
import com.tera.homepage.model.MediaType;
import com.tera.homepage.repository.ElasticsearchIndexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ElasticsearchIndexRepositoryImpl implements ElasticsearchIndexRepository {
    @Autowired
    private ElasticsearchClient elasticsearchClient;

    private final String INDEX = "media";

    @Override
    public boolean saveMedia(Media media) {
        IndexRequest<Media> request = IndexRequest.of(i -> i
                .index(INDEX)
                .id(media.getId().toString())
                .document(media)
        );
        try {
            IndexResponse response = elasticsearchClient.index(request);
            if (response.result() != Result.NotFound) {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Media> findMediaByMediaType(MediaType mediaType) {
        List<Media> result = new ArrayList<>();
        Query filterExpired = RangeQuery.of(m -> m
                .field("expiredtime")
                .gte(JsonData.of("now")))._toQuery();
        SearchRequest request = SearchRequest.of(s -> s
                .query(q -> q
                        .bool(b -> b
                                .filter(ft -> ft
                                        .range(r -> r
                                                .field("expiredTime").gte(JsonData.of("now"))))
                                .must(m -> m
                                        .term(trm -> trm
                                                .field("mediaType").value(mediaType.toString())))
                        )
                )
        );
        try {
            SearchResponse<Media> response = elasticsearchClient.search(request, Media.class);
            response.hits().hits().forEach(each -> result.add(each.source()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
