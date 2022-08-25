package com.tera.homepage.service;

import com.tera.homepage.dto.InputItem;
import com.tera.homepage.model.Media;

import java.util.List;

public interface ElasticsearchIndexService {
    boolean saveItem(InputItem inputItem);

    void removeExpiredItems();

    List<Media> getListExpiredItems();
}
