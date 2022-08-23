package com.tera.homepage.service;

import com.tera.homepage.dto.InputItem;
import com.tera.homepage.model.Item;

public interface IMediaService {
    Item findItemById(Integer id);
    void createNewItem(InputItem inputItem);
}
