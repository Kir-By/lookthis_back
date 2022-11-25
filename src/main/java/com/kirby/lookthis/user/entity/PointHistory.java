package com.kirby.lookthis.user.entity;

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
public class PointHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer OID;
    private String user_id;
    private Integer spotId;
    private String spotName;
    private Integer storeId;
    private String storeName;
    private Integer flyerId;
    private LocalDateTime createDate;
    private Integer status;
    private Integer point;

    @PrePersist
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }

}
