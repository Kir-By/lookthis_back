package com.kirby.lookthis.Spot.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kirby.lookthis.spot.entity.Spot;
import com.kirby.lookthis.spot.repository.SpotRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class SpotRepositoryTests {

	@Autowired
	private SpotRepository spotRepository;

	@Test
	public void insertSpot() {
		Spot spot = Spot.builder()
		.station("강남역")
		.stationExit(2)
		.lat(37.497337548034686)
		.lng(127.02822051275503)
		.build();

		spotRepository.save(spot);
	}
	
}
