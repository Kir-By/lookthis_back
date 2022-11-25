package com.kirby.lookthis.store.repository;

import com.kirby.lookthis.spot.dto.PointDto;
import com.kirby.lookthis.store.entity.UserFlyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.time.LocalDateTime;
import java.util.List;

public interface UserFlyerRepository extends JpaRepository<UserFlyer, Integer> {
    void deleteUserFlyerByInitDateLessThan(LocalDateTime localDateTime);
    List<UserFlyer> findUserFlyersByInitDateLessThan(LocalDateTime localDateTime);

    void deleteByFlyerSpotFlyerSpotId(Integer flyerSpotId);
}
