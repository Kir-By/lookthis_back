package com.kirby.lookthis.store.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Table(name = "flyer")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class Flyer {

    @Id
    @Column(name = "flyer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flyerId;

    @NotNull
    @Column(name="store_id")
    private Integer storeId;

    private String path;

    private LocalDateTime createDate;

    private LocalDateTime endValidDate;

    private Integer status;

    @OneToMany(mappedBy = "flyer")
	private List<FlyerSpot> flyerSpot = new ArrayList<>();

    @OneToMany(mappedBy = "flyer")
    private List<UserFlyer> userFlyers = new ArrayList<>();
}
