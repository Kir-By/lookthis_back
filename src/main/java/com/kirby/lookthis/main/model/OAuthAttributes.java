/*
package com.kirby.lookthis.main.model;

import com.kirby.lookthis.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Log4j2
public class OAuthAttributes {

    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String username;
    private String nickname;
    private String email;
    private String client_id;

    public static OAuthAttributes of(String registrationId,
                                     String userNameAttributeName,
                                     Map<String, Object> attributes) {

            return ofNaver("id", attributes);
    }

    // ofGoogle 생략

    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        */
/* JSON형태이기 때문에 Map을 통해 데이터를 가져온다. *//*

        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        log.info("naver response : " + response);

        return OAuthAttributes.builder()
                .username((String) response.get("client_id"))
                .email((String) response.get("email"))
                .nickname((String) response.get("nickname"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }
    public User toEntity() {
        return User.builder()
                .userId(client_id)
                .email(email)
                .nickname(nickname)
                .role("ROLE_MEMBER")
                .build();
    }
}
*/
