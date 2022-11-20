package com.kirby.lookthis.store.repository;

import com.kirby.lookthis.spot.dto.PointDto;
import com.kirby.lookthis.store.entity.UserFlyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserFlyerRepository extends JpaRepository<UserFlyer, Integer> {
}
