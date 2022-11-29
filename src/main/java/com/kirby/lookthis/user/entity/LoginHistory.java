package com.kirby.lookthis.user.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@DynamicUpdate
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class LoginHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer OID;
    private String user_id;
    private LocalDateTime createDate;
    private String status;
    private String platform;
    private String ipAddress;
    private String service;

    @PrePersist
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }

}
