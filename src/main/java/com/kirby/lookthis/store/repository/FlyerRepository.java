package com.kirby.lookthis.store.repository;

import com.kirby.lookthis.store.dto.FlyerDto;
import com.kirby.lookthis.store.dto.StoreDto;
import com.kirby.lookthis.store.entity.Flyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlyerRepository extends JpaRepository<Flyer, Integer> {

    @Query("select distinct new com.kirby.lookthis.store.dto.FlyerDto(f.flyerId, f.storeId, fs.spot.spotId, f.path, f.createDate, f.endValidDate, f.status) from Flyer f " +
            "left join FlyerSpot fs on f.flyerId = fs.flyer.flyerId " +
            "left join UserFlyer us on fs.flyerSpotId = us.flyerSpot.flyerSpotId " +
            "where fs.spot.spotId IN (:#{#spots}) " +
            "AND fs.flyer.flyerId not in (select f2.flyerId from Flyer f2 " +
            "left join FlyerSpot fs2 on f2.flyerId = fs2.flyer.flyerId " +
            "left join UserFlyer us2 on fs2.flyerSpotId = us2.flyerSpot.flyerSpotId " +
            "where us2.user.userId = :userId) ")
    List<FlyerDto> findFlyerBySpots(@Param("spots") List<Integer> spots, String userId);

    @Query("select distinct new com.kirby.lookthis.store.dto.FlyerDto(f.flyerId, f.storeId, fs.spot.spotId, f.path, f.createDate, f.endValidDate, f.status) from Flyer f " +
            "left join FlyerSpot fs on f.flyerId = fs.flyer.flyerId " +
            "left join UserFlyer us on fs.flyerSpotId = us.flyerSpot.flyerSpotId " +
            "where fs.flyer.flyerId in (select f2.flyerId from Flyer f2 " +
            "left join FlyerSpot fs2 on f2.flyerId = fs2.flyer.flyerId " +
            "left join UserFlyer us2 on fs2.flyerSpotId = us2.flyerSpot.flyerSpotId " +
            "where us2.user.userId = :userId order by us2.createDate desc ) ")
    List<FlyerDto> findFlyerHistoryBySpots(String userId);

    @Query("select f from Flyer f " +
            "where f.storeId = :#{#storeDto.storeId} ")
    List<Flyer> getStoreFlyerList(@Param("storeDto") StoreDto storeDto);
}
