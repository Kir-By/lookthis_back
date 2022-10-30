package com.kirby.lookthis.store.service;

import com.kirby.lookthis.spot.dto.SpotDto;
import com.kirby.lookthis.spot.entity.Spot;
import com.kirby.lookthis.store.dto.FlyerDto;
import com.kirby.lookthis.store.dto.FlyerSpotDto;
import com.kirby.lookthis.store.dto.StoreDto;
import com.kirby.lookthis.store.entity.Flyer;
import com.kirby.lookthis.store.entity.FlyerSpot;
import com.kirby.lookthis.store.entity.Store;
import com.kirby.lookthis.user.entity.User;

import java.util.List;

public interface StoreService {
    void insertStore(StoreDto storeDto);
    void insertFlyer(FlyerDto flyerDto);
    void insertFlyerSpot(FlyerSpotDto flyerSpotDto);

    default Store storeDtoToEntity(StoreDto storeDto){
        User user = User.builder()
                .userId(storeDto.getUserId())
                .build();

        Store store = Store.builder()
                .user(user)
                .address(storeDto.getAddress())
                .authStatus(storeDto.isAuthStatus())
                .storeId(storeDto.getStoreId())
                .authUser(storeDto.getAuthUser())
                .lat(storeDto.getLat())
                .lng(storeDto.getLng())
                .storeName(storeDto.getStoreName())
                .registration(storeDto.getRegistration())
                .registrationNum(storeDto.getRegistrationNum())
                .build();

        return store;
    }

    default StoreDto storeEntityToDto(Store store){
        StoreDto dto = StoreDto.builder()
                .address(store.getAddress())
                .authStatus(store.isAuthStatus())
                .lat(store.getLat())
                .storeId(store.getStoreId())
                .lng(store.getLng())
                .userId(store.getUser().getUserId())
                .authUser(store.getAuthUser())
                .storeName(store.getStoreName())
                .registration(store.getRegistration())
                .registrationNum(store.getRegistrationNum())
                .build();
        return dto;
    }

    default FlyerDto flyerEntityToDto(Flyer flyer){
        FlyerDto dto = FlyerDto.builder()
                .createDate(flyer.getCreateDate())
                .endValidDate(flyer.getEndValidDate())
                .flyerId(flyer.getFlyerId())
                .path(flyer.getPath())
                .status(flyer.getStatus())
                .storeId(flyer.getStoreId())
                .build();
        return dto;
    }

    default Flyer flyerDtoToEntity(FlyerDto flyerDto){
        Flyer flyer = Flyer.builder()
                .storeId(flyerDto.getStoreId())
                .status(flyerDto.getStatus())
                .flyerId(flyerDto.getFlyerId())
                .path(flyerDto.getPath())
                .endValidDate(flyerDto.getEndValidDate())
                .createDate(flyerDto.getCreateDate())
                .build();
        return flyer;
    }

    default FlyerSpot flyerSpotDtoToEntity(FlyerSpotDto flyerSpotDto){
        Flyer flyer = Flyer.builder()
                .flyerId(flyerSpotDto.getFlyerId())
                .storeId(flyerSpotDto.getStoreId())
                .build();
        Spot spot = Spot.builder()
                .spotId(flyerSpotDto.getSpotId())
                .build();
        FlyerSpot flyerSpot = FlyerSpot.builder()
                .flyer(flyer)
                .spot(spot)
                .build();

        return flyerSpot;
    }
}
