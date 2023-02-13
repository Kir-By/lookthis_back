package com.kirby.lookthis.spot.controller;

import com.kirby.lookthis.spot.dto.PointDto;
import com.kirby.lookthis.spot.dto.SpotDto;
import com.kirby.lookthis.spot.entity.Spot;
import com.kirby.lookthis.spot.service.SpotService;
import com.kirby.lookthis.store.dto.FlyerDto;
import com.kirby.lookthis.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SpotController {
    private final SpotService spotService;
    private final UserService userService;

    @PostMapping(value = "spots")
    public List<FlyerDto> getFlyerList(@RequestBody SpotDto spotDto) {

        return spotService.getFlyerList(spotDto);
    }

    @PostMapping(value = "spot/getFlyerHistoryList")
    public List<FlyerDto> getFlyerHistoryList(@RequestBody SpotDto spotDto) {

        return spotService.getFlyerHistoryList(spotDto);
    }

    @PostMapping(value = "spot/getSpotList")
    public List<Spot> getSpotList() {
        return spotService.getSpotList();
    }

    @PutMapping(value = "spot/insertPoint", produces = "application/json")
    public String insertPoint(@RequestBody PointDto pointDto) {

        return spotService.insertPoint(pointDto);
    }
}
