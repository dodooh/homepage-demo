package com.tera.homepage.service;

import com.tera.homepage.dto.InputItem;
import com.tera.homepage.model.Item;
import com.tera.homepage.model.Media;
import com.tera.homepage.model.MediaType;

import java.util.List;

public interface IMediaService {
    void createNewItem(InputItem inputItem);

    Item findItemByIdAndMediaType(Integer id, MediaType mediaType);

    void removeExpiredItems(List<Media> expiredList);
}
