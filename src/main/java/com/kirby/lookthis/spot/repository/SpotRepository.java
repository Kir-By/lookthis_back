package com.kirby.lookthis.spot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kirby.lookthis.spot.entity.Spot;

public interface SpotRepository extends JpaRepository<Spot, Integer> {
	
}
