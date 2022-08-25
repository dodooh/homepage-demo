package com.tera.homepage.service.impl;


import com.tera.homepage.dto.InputItem;
import com.tera.homepage.model.Media;
import com.tera.homepage.repository.ElasticsearchIndexRepository;
import com.tera.homepage.service.ElasticsearchIndexService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElasticsearchIndexServiceImpl implements ElasticsearchIndexService {
    @Autowired
    private ElasticsearchIndexRepository elasticsearchIndexRepository;

    @Override
    public boolean saveItem(InputItem inputItem) {
        Media media = new Media();
        BeanUtils.copyProperties(inputItem, media);
        return elasticsearchIndexRepository.saveMedia(media);
    }

    @Override
    public void removeExpiredItems() {
        elasticsearchIndexRepository.removeExpiredItems();
    }

    @Override
    public List<Media> getListExpiredItems() {
        return this.elasticsearchIndexRepository.getListExpiredItems();
    }
}
