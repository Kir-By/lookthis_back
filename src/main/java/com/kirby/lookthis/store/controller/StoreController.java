package com.kirby.lookthis.store.controller;

import com.kirby.lookthis.store.dto.FlyerDto;
import com.kirby.lookthis.store.dto.FlyerSpotDto;
import com.kirby.lookthis.spot.dto.PointDto;
import com.kirby.lookthis.store.dto.StoreDto;
import com.kirby.lookthis.store.entity.Flyer;
import com.kirby.lookthis.store.entity.Store;
import com.kirby.lookthis.store.service.StoreService;
import com.kirby.lookthis.user.dto.UserDto;
import com.kirby.lookthis.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StoreController {

    private final StoreService storeService;

    @PutMapping(value = "/saveStore", produces = "application/json")
    public void insertStore(@RequestBody StoreDto storeDto) {
        storeService.insertStore(storeDto);
    }

    @PutMapping(value = "/saveFlyer", produces = "application/json")
    public void insertFlyer(@RequestBody FlyerDto flyerDto) {
        storeService.insertFlyer(flyerDto);
    }

    @PutMapping(value = "/insertFlyerSpot", produces = "application/json")
    public void insertFlyerSpot(@RequestBody FlyerSpotDto flyerSpotDto) {
        storeService.insertFlyerSpot(flyerSpotDto);
    }

    @PostMapping(value = "/getStoreFlyerList", produces = "application/json")
    public List<Flyer> getStoreFlyerList(@RequestBody StoreDto storeDto){

        return storeService.getStoreFlyerList(storeDto);
    }

    @PostMapping(value = "/getStoreList", produces = "application/json")
    public List<Store> getStoreList(@RequestBody UserDto userDto){

        return storeService.getStoreList(userDto);
    }

}
