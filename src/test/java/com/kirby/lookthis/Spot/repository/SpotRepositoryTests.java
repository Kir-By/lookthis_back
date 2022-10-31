package com.kirby.lookthis.Spot.repository;

import com.kirby.lookthis.spot.dto.SpotDto;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kirby.lookthis.spot.entity.Spot;
import com.kirby.lookthis.spot.repository.SpotRepository;

import lombok.extern.log4j.Log4j2;

import javax.transaction.Transactional;
import java.util.List;

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

	@Test
	@Transactional
	public void getSpotListTest() {
		log.info("=============================================");
		SpotDto spotDto = SpotDto.builder()
				.lat(37.504548)
				.lng(127.024501)
				.build();
		List<Integer> spotList= spotRepository.getSpotListBySpotDto(spotDto);
		spotList.stream().forEach(spot -> log.info(spot.toString()));
	}
	
}
