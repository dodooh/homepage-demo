package com.tera.homepage.controller;


import com.tera.homepage.dto.InputItem;
import com.tera.homepage.service.ElasticsearchIndexService;
import com.tera.homepage.service.ILinkPlayService;
import com.tera.homepage.service.IMediaAssetService;
import com.tera.homepage.service.IMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/consumer")
public class ConsumerController {
    @Autowired
    private IMediaService mediaService;
    @Autowired
    private IMediaAssetService mediaAssetService;
    @Autowired
    private ILinkPlayService linkPlayService;

    @Autowired
    private ElasticsearchIndexService elasticsearchIndexService;

    @PostMapping()
    public ResponseEntity<?> createNewItem(@RequestBody InputItem inputItem) {
        //1 elasticsearch
        boolean isSave = this.elasticsearchIndexService.saveItem(inputItem);
        this.mediaService.createNewItem(inputItem);
        this.mediaAssetService.createNewMediaAsset(inputItem);
        this.linkPlayService.createNewLinkPlay(inputItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
