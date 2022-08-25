package com.tera.homepage.controller;

import com.tera.homepage.dto.ItemDto;
import com.tera.homepage.dto.ItemQuery;
import com.tera.homepage.model.Item;
import com.tera.homepage.model.LinkPlay;
import com.tera.homepage.model.MediaAsset;
import com.tera.homepage.service.ILinkPlayService;
import com.tera.homepage.service.IMediaAssetService;
import com.tera.homepage.service.IMediaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GraphQLController {
    @Autowired
    private IMediaService mediaService;
    @Autowired
    private ILinkPlayService linkPlayService;
    @Autowired
    private IMediaAssetService mediaAssetService;

    @QueryMapping
    public ItemDto getItemById(@Argument("itemQuery") ItemQuery itemQuery) {
        Item item = mediaService.findItemByIdAndMediaType(itemQuery.getId(),itemQuery.getMediaType());
        ItemDto itemDto = new ItemDto();
        BeanUtils.copyProperties(item, itemDto);
        itemDto.setPlatform(itemQuery.getPlatform());
        return itemDto;
    }

    @SchemaMapping(typeName = "Item")
    LinkPlay linkPlay(ItemDto item) {
        return this.linkPlayService.findLinkPlayByItemIdAndPlatfom(item.getId(), item.getPlatform());
    }

    @SchemaMapping(typeName = "Item")
    MediaAsset mediaAsset(ItemDto item) {
        return this.mediaAssetService.findMediaAssetByItemId(item.getId());
    }

}
