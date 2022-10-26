package com.kirby.lookthis.store.entity;

import javax.persistence.*;

import com.kirby.lookthis.spot.entity.Spot;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Table(name = "flyer_spot")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class FlyerSpot {

	@Id
	@Column(name = "flyer_spot_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer flyerSpotId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "flyer_id")
	private Flyer flyer; 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "spot_id")
	private Spot spot; 

}
