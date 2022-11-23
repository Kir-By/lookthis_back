package com.kirby.lookthis.store.service;

import com.kirby.lookthis.spot.entity.Spot;
import com.kirby.lookthis.spot.repository.SpotRepository;
import com.kirby.lookthis.store.dto.FlyerDto;
import com.kirby.lookthis.store.dto.FlyerSpotDto;
import com.kirby.lookthis.store.dto.StoreDto;
import com.kirby.lookthis.store.entity.Flyer;
import com.kirby.lookthis.store.entity.FlyerSpot;
import com.kirby.lookthis.store.entity.Store;
import com.kirby.lookthis.store.repository.FlyerRepository;
import com.kirby.lookthis.store.repository.FlyerSpotRepository;
import com.kirby.lookthis.store.repository.StoreRepository;
import com.kirby.lookthis.store.repository.UserFlyerRepository;
import com.kirby.lookthis.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{

    private final StoreRepository storeRepository;
    private final FlyerRepository flyerRepository;
    private final FlyerSpotRepository flyerSpotRepository;
    private final SpotRepository spotRepository;
    private final UserFlyerRepository userFlyerRepository;

    @Override
    public Integer insertStore(StoreDto storeDto) {
        Store store = storeDtoToEntity(storeDto);
        return storeRepository.save(store).getStoreId();
    }

    @Override
    public Integer insertFlyer(FlyerDto flyerDto) {
        Flyer flyer = flyerDtoToEntity(flyerDto);
        return flyerRepository.save(flyer).getFlyerId();
    }

    @Override
    public void insertFlyerSpot(FlyerSpotDto flyerSpotDto) {
        FlyerSpot flyerSpot = flyerSpotDtoToEntity(flyerSpotDto);
        flyerSpotRepository.save(flyerSpot);
    }

    @Override
    public List<Flyer> getStoreFlyerList(StoreDto storeDto) {
        return flyerRepository.getStoreFlyerList(storeDto);
    }

    @Override
    public List<Store> getStoreList(UserDto userDto) {
        return storeRepository.getStoreList(userDto);
    }

    @Override
    public List<Spot> getFlyerSpotList(FlyerDto flyerDto) {
        return spotRepository.getFlyerSpotList(flyerDto);
    }

    @Transactional
    @Override
    public String deleteFlyerSpot(FlyerSpotDto flyerSpotDto) {
        Integer flyerSpotId = flyerSpotRepository.getFlyerSpotIdForDelete(flyerSpotDto);
        userFlyerRepository.deleteByFlyerSpotFlyerSpotId(flyerSpotId);
        flyerSpotRepository.deleteById(flyerSpotId);
        return "success";
    }
}
