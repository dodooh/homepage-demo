package com.tera.homepage.controller;


import com.tera.homepage.dto.InputItem;
import com.tera.homepage.model.Item;
import com.tera.homepage.service.ElasticsearchIndexService;
import com.tera.homepage.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/consumer")
public class ConsumerController {

    @Autowired
    private ElasticsearchIndexService elasticsearchIndexService;

    @PostMapping()
    public ResponseEntity<?> createNewItem(@RequestBody InputItem inputItem) {
        //1 elasticsearch
        boolean isSave = this.elasticsearchIndexService.saveItem(inputItem);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
