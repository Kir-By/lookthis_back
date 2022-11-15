package com.kirby.lookthis.store.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Table(name = "flyer")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@DynamicUpdate
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

    @PrePersist
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }
}
