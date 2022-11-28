package com.kirby.lookthis.main.security;

import com.kirby.lookthis.main.uil.JwtUtil;
import com.kirby.lookthis.user.entity.User;
import com.kirby.lookthis.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@Log4j2
@RequiredArgsConstructor
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        User user = userRepository.findByUserId(request.getParameter("userId"));

        String id = user.getUserId();
        String name = user.getName();

        Map<String, Object> jwtInfo = new HashMap<>();
        jwtInfo.put("userId", id);
        jwtInfo.put("name", name);
        String jwt = jwtUtil.generateToken(jwtInfo, id);
        String url = makeRedirectUrl(request.getHeader("Referer"), jwt);

        if (response.isCommitted()) {
            log.debug("응답이 이미 커밋된 상태입니다. " + url + "로 리다이렉트하도록 바꿀 수 없습니다.");
            return;
        }

        getRedirectStrategy().sendRedirect(request, response, url);
    }

    private String makeRedirectUrl(String url, String token) {
        return UriComponentsBuilder.fromUriString(url + "oauth2/redirect/"+token)
                .build().toUriString();
    }

}
