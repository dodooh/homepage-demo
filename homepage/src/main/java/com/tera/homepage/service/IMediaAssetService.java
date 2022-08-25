package com.tera.homepage.service;

import com.tera.homepage.dto.InputItem;
import com.tera.homepage.model.Media;
import com.tera.homepage.model.MediaAsset;

import java.util.List;

public interface IMediaAssetService {
    MediaAsset findMediaAssetByItemId(Integer id);
    void createNewMediaAsset(InputItem inputItem);

    void removeExpiredMediaAsset(List<Media> expiredList);
}
