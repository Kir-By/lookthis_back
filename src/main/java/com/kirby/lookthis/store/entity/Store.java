package com.kirby.lookthis.store.entity;

import com.kirby.lookthis.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Table(name = "store")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class Store {

    @Id
    @Column(name = "store_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer storeId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "store_name")
    private String storeName;

    private String address;
    private Double lat;
    private Double lng;

    @Column(name = "auth_status")
    private boolean authStatus;

    private String registration;

    @Column(name = "registration_num")
    private Integer registrationNum;

    @Column(name = "auth_user")
    private String authUser;
}
