package com.kirby.lookthis.spot.service;

import com.kirby.lookthis.spot.dto.SpotDto;
import com.kirby.lookthis.spot.entity.Spot;
import com.kirby.lookthis.spot.repository.SpotRepository;
import com.kirby.lookthis.store.entity.Flyer;
import com.kirby.lookthis.store.repository.FlyerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class SpotServiceImpl implements SpotService{

    private final SpotRepository spotRepository;
    private final FlyerRepository flyerRepository;

    @Override
    public List<Flyer> getFlyerList(SpotDto spotDto) {
        List<Integer> spotList = spotRepository.getSpotListBySpotDto(spotDto);

        return flyerRepository.findFlyerBySpots(spotList);
    }

    @Override
    public List<Flyer> getFlyerHistoryList(SpotDto spotDto) {
        List<Integer> spotList = spotRepository.getSpotListBySpotDto(spotDto);

        return flyerRepository.findFlyerHistoryBySpots(spotList);
    }

    @Override
    public List<Spot> getSpotList() {
        return spotRepository.findAll();
    }
}
