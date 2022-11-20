package com.kirby.lookthis.main.contoller;

import com.google.common.net.HttpHeaders;
import lombok.extern.log4j.Log4j2;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Map;

@Controller
@Log4j2
@RequestMapping(value = "/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

    @Value("${spring.security.oauth2.client.provider.naver.authorization-uri}")
    String NAVER_AUTH_URI;

    @Value("${spring.security.oauth2.client.registration.naver.client-id}")
    String clientId;

    @Value("${spring.security.oauth2.client.registration.naver.client-secret}")
    String clientSecret;

    @GetMapping(value = "/api/naver/oauth")
    public String naverConnect() {
        SecureRandom random = new SecureRandom();
        String state = new BigInteger(130, random).toString(32);

        StringBuilder url = new StringBuilder();
        url.append(NAVER_AUTH_URI + "?");
        url.append("client_id=" + clientId);
        url.append("&response_type=code");
        url.append("&redirect_url=http://localhost:8080/auth/api/naver/callback");
        url.append("&state=" + state);
        return "redirect:" + url;
    }

    @GetMapping(value = "/api/naver/callback")
    public String naverLogin(String code, String state) {
        log.info("test");
        WebClient webClient = WebClient.builder()
                .baseUrl("https://nid.naver.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        JSONObject response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/oauth2.0/token")
                        .queryParam("client_id", clientId)
                        .queryParam("client_secret", clientSecret)
                        .queryParam("grant_type", "authorization_code")
                        .queryParam("state", state)
                        .queryParam("code", code)
                        .build())
                .retrieve().bodyToMono(JSONObject.class).block();

        String token = response.get("access_token").toString();
        getUserInfo(token);
        return "redirect:https://lookthistest.nhncloud.paas-ta.com/flyer";
    }

    public void getUserInfo(String accessToken) {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://openapi.naver.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        JSONObject response = webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/nid/me")
                        .build())
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .bodyToMono(JSONObject.class).block();

        Map<String, Object> res = (Map<String, Object>) response.get("response");
        String id = (String) res.get("id");
        String nickName = (String) res.get("nickname");

        log.info(id);
        log.info(nickName);
    }
}
