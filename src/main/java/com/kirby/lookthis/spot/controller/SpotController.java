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

    @GetMapping(value = "spot/flyers")
    public List<FlyerDto> getFlyerList(SpotDto spotDto) {

        return spotService.getFlyerList(spotDto);
    }

    @GetMapping(value = "spot/history/flyers")
    public List<FlyerDto> getFlyerHistoryList(SpotDto spotDto) {

        return spotService.getFlyerHistoryList(spotDto);
    }

    @GetMapping(value = "spots")
    public List<Spot> getSpotList() {
        return spotService.getSpotList();
    }

    @PutMapping(value = "spot/point", produces = "application/json")
    public String insertPoint(@RequestBody PointDto pointDto) {

        return spotService.insertPoint(pointDto);
    }
}
