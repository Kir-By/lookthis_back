package com.kirby.lookthis.spot.repository;

import com.kirby.lookthis.spot.dto.SpotDto;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kirby.lookthis.spot.entity.Spot;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpotRepository extends JpaRepository<Spot, Integer> {

    @Query("select s from Spot s " +
            "where ABS(s.lat - :#{#spotDto.lat}) < 0.0005 " +
            "and ABS(s.lng - :#{#spotDto.lng}) < 0.0005 ")
    List<Spot> getSpotListBySpotDto(@Param("spotDto")SpotDto spotDto);
}
