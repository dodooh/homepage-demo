package com.tera.homepage.repository;

import com.tera.homepage.model.Item;
import com.tera.homepage.model.MediaType;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CassandraRepository<Item, Integer> {
    Item findItemByIdAndMediaType(Integer id, MediaType mediaType);
}
