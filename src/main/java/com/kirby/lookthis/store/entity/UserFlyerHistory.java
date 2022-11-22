package com.kirby.lookthis.store.entity;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer OID;
    private Integer userFlyerId;
    private String user_id;
    private Integer flyer_spot_id;
    private LocalDateTime createDate;
    private Integer point;

}
