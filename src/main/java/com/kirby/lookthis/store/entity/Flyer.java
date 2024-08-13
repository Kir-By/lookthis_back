package com.kirby.lookthis.store.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicUpdate;

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

    @Comment("0: 인코딩 전, 1: 인코딩 완료")
    private Integer status;

    @Comment("이미지 확장자")
    private String type;

    @Comment("임시 위치")
    private String tempPath;

    @Comment("에러 메시지")
    private String error_message;

    @PrePersist
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }
}
