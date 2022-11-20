package com.kirby.lookthis.store.repository;

import com.kirby.lookthis.spot.entity.Spot;
import com.kirby.lookthis.store.dto.FlyerDto;
import com.kirby.lookthis.store.dto.FlyerSpotDto;
import com.kirby.lookthis.store.entity.Flyer;
import com.kirby.lookthis.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlyerRepository extends JpaRepository<Flyer, Integer> {

    @Query("select new com.kirby.lookthis.store.dto.FlyerDto(f.flyerId, f.storeId, fs.spot.spotId, f.path, f.createDate, f.endValidDate, f.status) from Flyer f " +
            "left join FlyerSpot fs on f.flyerId = fs.flyer.flyerId " +
            "left join UserFlyer us on fs.flyerSpotId = us.flyerSpot.flyerSpotId " +
            "where fs.spot.spotId IN (:#{#spots}) " +
            "AND us.user.userId is null ")
    List<FlyerDto> findFlyerBySpots(@Param("spots") List<Integer> spots);

    @Query("select new com.kirby.lookthis.store.dto.FlyerDto(f.flyerId, f.storeId, fs.spot.spotId, f.path, f.createDate, f.endValidDate, f.status) from Flyer f " +
            "left join FlyerSpot fs on f.flyerId = fs.flyer.flyerId " +
            "left join UserFlyer us on fs.flyerSpotId = us.flyerSpot.flyerSpotId " +
            "where fs.spot.spotId IN (:#{#spots}) " +
            "AND us.user.userId is not null ")
    List<FlyerDto> findFlyerHistoryBySpots(@Param("spots") List<Integer> spots);
}
