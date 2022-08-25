package com.tera.homepage.service.impl;

import com.tera.homepage.dto.InputItem;
import com.tera.homepage.model.LinkPlay;
import com.tera.homepage.model.Media;
import com.tera.homepage.model.Platform;
import com.tera.homepage.repository.LinkPlayRepository;
import com.tera.homepage.service.ILinkPlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkPlayService implements ILinkPlayService {
    @Autowired
    private LinkPlayRepository linkPlayRepository;

    @Override
    public LinkPlay findLinkPlayByItemIdAndPlatfom(Integer id, Platform platform) {
        return this.linkPlayRepository.findLinkPlayByItemIdAndPlatform(id, platform);
    }

    @Override
    public void createNewLinkPlay(InputItem inputItem) {

        for (LinkPlay link : inputItem.getLinkPlay()) {
            LinkPlay linkPlay = new LinkPlay();
            linkPlay = link;
            linkPlay.setItemId(inputItem.getId());
            this.linkPlayRepository.save(linkPlay);
        }
    }

    @Override
    public void removeExpiredLinkPlay(List<Media> expiredList) {
        for (Media item : expiredList) {
            this.linkPlayRepository.deleteLinkPlayByItemIdAndPlatform(item.getId(),Platform.IOS);
            this.linkPlayRepository.deleteLinkPlayByItemIdAndPlatform(item.getId(),Platform.ANDROID);
        }
    }
}
