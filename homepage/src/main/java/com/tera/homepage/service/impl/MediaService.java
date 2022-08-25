package com.tera.homepage.service.impl;

import com.tera.homepage.dto.InputItem;
import com.tera.homepage.model.Item;
import com.tera.homepage.model.Media;
import com.tera.homepage.model.MediaType;
import com.tera.homepage.repository.ItemRepository;
import com.tera.homepage.service.IMediaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaService implements IMediaService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void createNewItem(InputItem inputItem) {
        Item item = new Item();
        BeanUtils.copyProperties(inputItem, item);
        this.itemRepository.save(item);
    }

    @Override
    public Item findItemByIdAndMediaType(Integer id, MediaType mediaType) {
        return this.itemRepository.findItemByIdAndMediaType(id, mediaType);
    }

    @Override
    public void removeExpiredItems(List<Media> expiredList) {
        for (Media item : expiredList) {
            this.itemRepository.deleteItemByIdAndMediaType(item.getId(), item.getMediaType());
        }
    }
}
