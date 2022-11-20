package com.kirby.lookthis.spot.service;

import com.kirby.lookthis.spot.dto.PointDto;
import com.kirby.lookthis.spot.dto.SpotDto;
import com.kirby.lookthis.spot.entity.Spot;
import com.kirby.lookthis.store.dto.FlyerDto;
import com.kirby.lookthis.store.entity.Flyer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SpotService {

    List<FlyerDto> getFlyerList(SpotDto spotDto);
    List<FlyerDto> getFlyerHistoryList(SpotDto spotDto);

    List<Spot> getSpotList();

    String insertPoint(PointDto pointDto);
}
