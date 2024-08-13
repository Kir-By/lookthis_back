package com.kirby.lookthis.main.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@DynamicUpdate
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class SystemError {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer errorCode;
    private String user_id;
    private LocalDateTime createDate;
    private String url;
    private String bodypart;
    private String message;

    @PrePersist
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }
}
