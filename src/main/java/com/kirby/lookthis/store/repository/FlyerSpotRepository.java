package com.kirby.lookthis.store.repository;

import com.kirby.lookthis.spot.dto.PointDto;
import com.kirby.lookthis.store.entity.FlyerSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlyerSpotRepository extends JpaRepository<FlyerSpot, Integer> {

    @Query(value = "select fs from FlyerSpot fs " +
            "where fs.flyer.flyerId = :#{#pointDto.flyerId} " +
            "AND fs.spot.spotId = #{#pointDto.spotId}", nativeQuery = true)
    List<FlyerSpot> getFlyerSpotId(@Param("pointDto")PointDto pointDto);
}
