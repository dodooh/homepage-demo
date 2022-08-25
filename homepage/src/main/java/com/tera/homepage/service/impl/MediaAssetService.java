package com.tera.homepage.service.impl;

import com.tera.homepage.dto.InputItem;
import com.tera.homepage.model.Media;
import com.tera.homepage.model.MediaAsset;
import com.tera.homepage.repository.MediaAssetRepository;
import com.tera.homepage.service.IMediaAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MediaAssetService implements IMediaAssetService {
    @Autowired
    private MediaAssetRepository mediaAssetRepository;

    @Override
    public MediaAsset findMediaAssetByItemId(Integer id) {
        return this.mediaAssetRepository.findMediaAssetByItemId(id);
    }

    @Override
    public void createNewMediaAsset(InputItem inputItem) {
        MediaAsset mediaAsset = new MediaAsset();
        mediaAsset = inputItem.getMediaAsset();
        mediaAsset.setItemId(inputItem.getId());
        this.mediaAssetRepository.save(mediaAsset);
    }

    @Override
    public void removeExpiredMediaAsset(List<Media> expiredList) {
        for (Media item : expiredList) {
            this.mediaAssetRepository.deleteMediaAssetByItemId(item.getId());
        }
    }
}
