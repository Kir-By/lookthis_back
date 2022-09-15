package com.kirby.lookthis.store.repository;

import com.kirby.lookthis.store.entity.Flyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlyerRepository extends JpaRepository<Flyer, Integer> {
}
