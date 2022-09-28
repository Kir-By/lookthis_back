package com.kirby.lookthis.store.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FlyerSpotDto {
    private Integer flyerSpotId;
    private Integer flyerId;
    private Integer spotId;
    private Integer storeId;

}
