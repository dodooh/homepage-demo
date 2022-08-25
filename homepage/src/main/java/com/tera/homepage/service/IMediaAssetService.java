package com.tera.homepage.service;

import com.tera.homepage.dto.InputItem;
import com.tera.homepage.model.MediaAsset;

public interface IMediaAssetService {
    MediaAsset findMediaAssetByItemId(Integer id);
    void createNewMediaAsset(InputItem inputItem);
}
