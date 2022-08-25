package com.tera.homepage.repository;

import com.tera.homepage.model.MediaAsset;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface MediaAssetRepository extends CassandraRepository<MediaAsset,Integer> {
    MediaAsset findMediaAssetByItemId(Integer itemId);
    void deleteMediaAssetByItemId(Integer itemId);
}
