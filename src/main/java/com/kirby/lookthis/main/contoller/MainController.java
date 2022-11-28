package com.kirby.lookthis.main.contoller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Controller("/")
public class MainController {

    @GetMapping("/")
    public String testMain(HttpServletRequest request) {
       log.info(request.getRemoteHost());

        return "test";
    }
}
