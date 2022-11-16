package com.kirby.lookthis.store.controller;

import com.kirby.lookthis.spot.dto.SpotDto;
import com.kirby.lookthis.store.dto.FlyerDto;
import com.kirby.lookthis.store.dto.FlyerSpotDto;
import com.kirby.lookthis.store.dto.StoreDto;
import com.kirby.lookthis.store.entity.Flyer;
import com.kirby.lookthis.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
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


}
