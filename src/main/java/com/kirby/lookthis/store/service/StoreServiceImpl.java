package com.kirby.lookthis.store.service;

import com.kirby.lookthis.store.dto.FlyerDto;
import com.kirby.lookthis.store.dto.FlyerSpotDto;
import com.kirby.lookthis.store.dto.StoreDto;
import com.kirby.lookthis.store.entity.Flyer;
import com.kirby.lookthis.store.entity.FlyerSpot;
import com.kirby.lookthis.store.entity.Store;
import com.kirby.lookthis.store.repository.FlyerRepository;
import com.kirby.lookthis.store.repository.FlyerSpotRepository;
import com.kirby.lookthis.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{

    private final StoreRepository storeRepository;
    private final FlyerRepository flyerRepository;
    private final FlyerSpotRepository flyerSpotRepository;

    @Override
    public void insertStore(StoreDto storeDto) {
        Store store = storeDtoToEntity(storeDto);
        storeRepository.save(store);
    }

    @Override
    public void insertFlyer(FlyerDto flyerDto) {
        Flyer flyer = flyerDtoToEntity(flyerDto);
        flyerRepository.save(flyer);
    }

    @Override
    public void insertFlyerSpot(FlyerSpotDto flyerSpotDto) {
        FlyerSpot flyerSpot = flyerSpotDtoToEntity(flyerSpotDto);
        flyerSpotRepository.save(flyerSpot);
    }
}
