package com.kirby.lookthis.spot.service;

import com.kirby.lookthis.spot.dto.SpotDto;
import com.kirby.lookthis.spot.entity.Spot;
import com.kirby.lookthis.store.entity.Flyer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SpotService {

    List<Flyer> getFlyerList(SpotDto spotDto);
    List<Flyer> getFlyerHistoryList(SpotDto spotDto);

    List<Spot> getSpotList();
}
