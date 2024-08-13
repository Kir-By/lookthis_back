package com.kirby.lookthis.store.entity;

import com.kirby.lookthis.spot.entity.Spot;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Builder
@Table(name = "flyer_spot")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@DynamicUpdate
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
