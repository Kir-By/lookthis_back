package com.kirby.lookthis.spot.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Builder
@Table(name = "spot")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@DynamicUpdate
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

	
}
