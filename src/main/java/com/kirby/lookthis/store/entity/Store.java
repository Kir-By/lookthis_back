package com.kirby.lookthis.store.entity;

import com.kirby.lookthis.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Builder
@Table(name = "store")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@DynamicUpdate
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
