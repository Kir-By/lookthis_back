package com.kirby.lookthis.main.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;




@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@RedisHash(value = "refreshToken", timeToLive = 60)
public class RefreshToken {

    @Id
    private String refreshToken;
    private String user_id;

}
