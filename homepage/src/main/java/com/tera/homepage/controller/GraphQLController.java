package com.tera.homepage.controller;

import com.tera.homepage.dto.ItemQuery;
import com.tera.homepage.model.Item;
import com.tera.homepage.model.LinkPlay;
import com.tera.homepage.model.MediaAsset;
import com.tera.homepage.service.ILinkPlayService;
import com.tera.homepage.service.IMediaAssetService;
import com.tera.homepage.service.IMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Controller
public class GraphQLController {
    @Autowired
    private IMediaService mediaService;
    @Autowired
    private ILinkPlayService linkPlayService;
    @Autowired
    private IMediaAssetService mediaAssetService;

    @QueryMapping
    public Item getItemById(@Argument("inputItem") ItemQuery itemQuery) {
        return mediaService.findItemById(itemQuery.getId());
    }

//    @BatchMapping
//    Map<Item, MediaAsset> mediaAsset(Item item) {
//        Map<Item, MediaAsset> mediaAssetMap = new HashMap<>();
//        mediaAssetMap.put(item, this.mediaAssetService.findMediaAssetByItemId(item.getId()));
//        return mediaAssetMap;
//    }
//
//    @BatchMapping
//    Map<Item, LinkPlay> linkPlay(Item item, ItemQuery itemQuery) {
//        Map<Item, LinkPlay> linkPlay = new HashMap<>();
//        linkPlay.put(item, this.linkPlayService.findLinkPlayByItemIdAndPlatfom(itemQuery.getId(), itemQuery.getPlatform()));
//        return linkPlay;
//    }

}
