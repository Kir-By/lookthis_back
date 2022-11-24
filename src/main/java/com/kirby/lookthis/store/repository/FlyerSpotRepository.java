package com.kirby.lookthis.store.repository;

import com.kirby.lookthis.spot.dto.PointDto;
import com.kirby.lookthis.store.dto.FlyerSpotDto;
import com.kirby.lookthis.store.entity.FlyerSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlyerSpotRepository extends JpaRepository<FlyerSpot, Integer> {

    @Query("select fs.flyerSpotId from FlyerSpot fs " +
            "where fs.flyer.flyerId = :#{#pointDto.flyerId} " +
            "and fs.spot.spotId = :#{#pointDto.spotId}")
    Integer getFlyerSpotId(@Param("pointDto")PointDto pointDto);

    @Query("select fs.flyerSpotId from FlyerSpot fs " +
            "where fs.flyer.flyerId = :#{#flyerSpotDto.flyerId} and fs.spot.spotId = :#{#flyerSpotDto.spotId}")
    Integer getFlyerSpotIdForDelete(FlyerSpotDto flyerSpotDto);
}
