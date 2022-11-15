package com.kirby.lookthis.user.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
    private String userId;
    private String password;
    private String auth;
    private String plateformtype;
    private String accesstoken;
    private String name;
    private LocalDateTime birth;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Integer point;
    private String phone;
    private String fcmToken;
}
