package com.tera.homepage.repository;

import com.tera.homepage.model.Item;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CassandraRepository<Item, Integer> {
    Item findItemById(Integer id);
}
