package com.kirby.lookthis.store.entity;

import com.kirby.lookthis.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Table(name = "user_store")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class UserStore {

    @Id
    @Column(name = "store_flyer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer storeFlyerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    private String spotId;

    private LocalDateTime createDate;
    private LocalDateTime initDate;

}
