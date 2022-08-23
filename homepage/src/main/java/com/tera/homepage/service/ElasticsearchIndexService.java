package com.tera.homepage.service;

import com.tera.homepage.dto.InputItem;

public interface ElasticsearchIndexService {
    boolean saveItem(InputItem inputItem);
}
