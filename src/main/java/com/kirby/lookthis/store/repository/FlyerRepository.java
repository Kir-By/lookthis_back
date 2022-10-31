package com.kirby.lookthis.store.repository;

import com.kirby.lookthis.spot.entity.Spot;
import com.kirby.lookthis.store.dto.FlyerSpotDto;
import com.kirby.lookthis.store.entity.Flyer;
import com.kirby.lookthis.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlyerRepository extends JpaRepository<Flyer, Integer> {

    @Query("select f from Flyer f " +
            "left join FlyerSpot fs on f.flyerId = fs.flyer.flyerId " +
            "left join UserFlyer us on fs.flyerSpotId = us.flyerSpot.flyerSpotId " +
            "where fs.spot.spotId IN (:#{#spots}) " +
            "AND us.user.userId is null ")
    List<Flyer> findFlyerBySpots(@Param("spots") List<Integer> spots);

    @Query("select f from Flyer f " +
            "left join FlyerSpot fs on f.flyerId = fs.flyer.flyerId " +
            "left join UserFlyer us on fs.flyerSpotId = us.flyerSpot.flyerSpotId " +
            "where fs.spot.spotId IN (:#{#spots}) " +
            "AND us.user.userId is not null ")
    List<Flyer> findFlyerHistoryBySpots(@Param("spots") List<Integer> spots);
}
