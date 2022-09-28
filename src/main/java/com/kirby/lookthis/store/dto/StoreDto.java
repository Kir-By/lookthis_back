package com.kirby.lookthis.store.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StoreDto {
    private Integer storeId;
    private String userId;
    private String storeName;
    private String address;
    private Double lat;
    private Double lng;
    private boolean authStatus;
    private String registration;
    private Integer registrationNum;
    private String authUser;
}
