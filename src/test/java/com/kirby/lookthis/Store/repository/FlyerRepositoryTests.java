package com.kirby.lookthis.Store.repository;

import com.kirby.lookthis.spot.dto.SpotDto;
import com.kirby.lookthis.spot.entity.Spot;
import com.kirby.lookthis.store.entity.Flyer;
import com.kirby.lookthis.store.repository.FlyerRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Log4j2
public class FlyerRepositoryTests {

    @Autowired
    private FlyerRepository flyerRepository;

    @Test
    public void insertFlyerTest() {
        Flyer flyer = Flyer.builder()
                .storeId(1)
                .path("/test/flyer/1")
                .createDate(LocalDateTime.now())
                .endValidDate(LocalDateTime.now())
                .build();

        flyerRepository.save(flyer);
    }

    @Test
    public void getFlyerListTest() {
        Spot spot = Spot.builder()
                .spotId(3)
                .build();
        SpotDto spotDto2 = new SpotDto();

        List<Spot> spoList = new ArrayList<>();
        spoList.add(spot);
        List<Flyer> flyerList = flyerRepository.findFlyerBySpots(spoList);
        flyerList.stream().forEach(flyer -> log.info(flyer));

    }
}
