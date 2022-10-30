package com.kirby.lookthis.spot.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SpotDto {
    private String userId;
    private double lat;
    private double lng;
}
