package com.tera.homepage.service.impl;

import com.tera.homepage.dto.InputItem;
import com.tera.homepage.model.Item;
import com.tera.homepage.repository.ItemRepository;
import com.tera.homepage.service.IMediaService;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediaService implements IMediaService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item findItemById(Integer id) {
        return this.itemRepository.findById(id).orElse(null);
    }

    @Override
    public void createNewItem(InputItem inputItem) {
        Item item = new Item();
        BeanUtils.copyProperties(inputItem,item);
        this.itemRepository.save(item);
    }
}
