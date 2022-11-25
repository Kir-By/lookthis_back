package com.kirby.lookthis.spot.repository;

import com.kirby.lookthis.spot.dto.SpotDto;
import com.kirby.lookthis.spot.entity.Spot;
import com.kirby.lookthis.store.dto.FlyerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpotRepository extends JpaRepository<Spot, Integer> {

    @Query("select s.spotId from Spot s " +
            "where ABS(s.lat - :#{#spotDto.lat}) < 0.0005 " +
            "and ABS(s.lng - :#{#spotDto.lng}) < 0.0005 ")
    List<Integer> getSpotListBySpotDto(@Param("spotDto") SpotDto spotDto);

    Spot findSpotBySpotId(Integer spotId);

    @Query("select s from Spot s " +
            "left join FlyerSpot fs on fs.spot.spotId = s.spotId " +
            "where fs.flyer.flyerId = :#{#flyerDto.flyerId} ")
    List<Spot> getFlyerSpotList(@Param("flyerDto") FlyerDto flyerDto);

}
