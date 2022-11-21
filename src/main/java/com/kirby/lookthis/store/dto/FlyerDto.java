package com.kirby.lookthis.store.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FlyerDto {
    private Integer flyerId;
    private Integer storeId;
    private Integer spotId;
    private String path;
    private LocalDateTime createDate;
    private LocalDateTime endValidDate;
    private Integer status;
    private MultipartFile flyerFile;
}
