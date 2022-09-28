package com.kirby.lookthis.store.repository;

import com.kirby.lookthis.store.entity.Flyer;
import com.kirby.lookthis.store.entity.FlyerSpot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlyerSpotRepository extends JpaRepository<FlyerSpot, Integer> {
}
