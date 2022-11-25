package com.kirby.lookthis.main.security;

import com.kirby.lookthis.main.uil.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        System.out.println(request.getRemoteHost());
        System.out.println(request.getRequestURL());
        System.out.println(request.getContextPath());
        System.out.println(authentication.getDetails());

        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();

        Map<String, Object> naver_account = (Map<String, Object>) oAuth2User.getAttributes();
        String id = (String) naver_account.get("id");
        String name = (String) naver_account.get("name");
        Map<String, Object> jwtInfo = new HashMap<>();
        jwtInfo.put("userId", id);
        jwtInfo.put("name", name);

        String jwt = jwtUtil.generateToken(jwtInfo, id);

        String url = makeRedirectUrl(jwt);
        System.out.println("url: " + url);

        if (response.isCommitted()) {
            logger.debug("응답이 이미 커밋된 상태입니다. " + url + "로 리다이렉트하도록 바꿀 수 없습니다.");
            return;
        }
        getRedirectStrategy().sendRedirect(request, response, url);
    }

    private String makeRedirectUrl(String token) {
        return UriComponentsBuilder.fromUriString("http://localhost:3000/oauth2/redirect/"+token)
                .build().toUriString();
    }
}
