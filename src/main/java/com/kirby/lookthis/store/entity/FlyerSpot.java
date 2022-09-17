package com.kirby.lookthis.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kirby.lookthis.spot.entity.Spot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
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

	@ManyToOne
	@JoinColumn(name = "flyer_id")
	private Flyer flyer; 

	@ManyToOne
	@JoinColumn(name = "spot_id")
	private Spot spot; 
	
}
