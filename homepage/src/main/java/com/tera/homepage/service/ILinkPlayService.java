package com.tera.homepage.service;

import com.tera.homepage.dto.InputItem;
import com.tera.homepage.model.LinkPlay;
import com.tera.homepage.model.Media;
import com.tera.homepage.model.Platform;

import java.util.List;

public interface ILinkPlayService {
    LinkPlay findLinkPlayByItemIdAndPlatfom(Integer id, Platform platform);
    void createNewLinkPlay(InputItem inputItem);

    void removeExpiredLinkPlay(List<Media> expiredList);
}
