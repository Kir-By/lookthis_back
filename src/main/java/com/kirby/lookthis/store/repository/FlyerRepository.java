package com.kirby.lookthis.store.repository;

import com.kirby.lookthis.spot.entity.Spot;
import com.kirby.lookthis.store.dto.FlyerSpotDto;
import com.kirby.lookthis.store.entity.Flyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlyerRepository extends JpaRepository<Flyer, Integer> {

    @Query("select f from Flyer f left join FlyerSpot fs on f.flyerId = fs.flyer.flyerId where fs.spot.spotId IN (:spots)")
    List<Flyer> findBySpots(@Param("spots") List<Integer> spots);
}
