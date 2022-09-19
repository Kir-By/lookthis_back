package com.kirby.lookthis.spot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kirby.lookthis.store.entity.FlyerSpot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@Table(name = "spot")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class Spot {

	@Id
	@Column(name = "spot_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer spotId;

	@Column(name = "station")
	private String station;

	@Column(name = "station_exit")
	private Integer stationExit;

	@Column(name = "lat")
	private Double lat;

	@Column(name = "lng")
	private Double lng;

	@OneToMany(mappedBy = "spot")
	private List<FlyerSpot> flyerSpot = new ArrayList<>();
	
}
