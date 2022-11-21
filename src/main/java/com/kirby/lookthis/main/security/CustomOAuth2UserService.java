package com.kirby.lookthis.main.security;

import com.kirby.lookthis.user.dto.UserDto;
import com.kirby.lookthis.user.entity.User;
import com.kirby.lookthis.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final HttpSession httpSession;

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        Map<String, Object> attributes = oAuth2User.getAttributes();

        Map<String, Object> naver_account = (Map<String, Object>) attributes.get("response");
        String email = (String) naver_account.get("email");
        String id = (String) naver_account.get("id");
        String phone = (String) naver_account.get("mobile");
        String birth = (String) naver_account.get("birthyear") +"-" +(String) naver_account.get("birthday");
        String name = (String) naver_account.get("name");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime birthday = LocalDate.parse(birth, formatter).atStartOfDay();

        User user = User.builder()
                .userId(id)
                .phone(phone)
                .birth(birthday)
                .name(name)
                .plateformtype("NAVER")
                .auth("ROLE_MEMBER")
                .password("NAVER")
                .build();

        if (userRepository.findById(id).isPresent()) {
            System.out.println("가입한적 있음.");
        } else {
            userRepository.save(user);
        }

        return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority("ROLE_MEMBER")), naver_account, "id");
    }

}
