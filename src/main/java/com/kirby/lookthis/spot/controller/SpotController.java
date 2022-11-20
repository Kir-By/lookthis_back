package com.kirby.lookthis.spot.controller;

import com.kirby.lookthis.spot.dto.SpotDto;
import com.kirby.lookthis.spot.entity.Spot;
import com.kirby.lookthis.spot.service.SpotService;
import com.kirby.lookthis.store.dto.FlyerSpotDto;
import com.kirby.lookthis.store.entity.Flyer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class SpotController {
    private final SpotService spotService;

    @PostMapping(value = "/getFlyerList")
    public List<Flyer> getFlyerList(@RequestBody SpotDto spotDto) {

        return spotService.getFlyerList(spotDto);
    }

    @PostMapping(value = "/getFlyerHistoryList")
    public List<Flyer> getFlyerHistoryList(@RequestBody SpotDto spotDto) {

        return spotService.getFlyerHistoryList(spotDto);
    }

    @PostMapping(value = "/getSpotList")
    public List<Spot> getSpotList() {
        return spotService.getSpotList();
    }

}
