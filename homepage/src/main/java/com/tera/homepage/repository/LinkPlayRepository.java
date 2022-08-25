package com.tera.homepage.repository;

import com.tera.homepage.model.LinkPlay;
import com.tera.homepage.model.Platform;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface LinkPlayRepository extends CassandraRepository<LinkPlay,Integer> {
    LinkPlay findLinkPlayByItemIdAndPlatform(Integer itemId, Platform platform);
}
