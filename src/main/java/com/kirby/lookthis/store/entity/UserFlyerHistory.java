package com.kirby.lookthis.store.entity;

import com.kirby.lookthis.user.entity.User;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Table
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@DynamicUpdate
public class UserFlyerHistory {

    @Id
    @Column(name = "user_flyer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userFlyerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flyer_spot_id")
    private FlyerSpot flyerSpot;

    private LocalDateTime createDate;
    private LocalDateTime initDate;

}
