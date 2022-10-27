package com.kirby.lookthis.main.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class MainController {

    @GetMapping("/")
    public String testMain() {
        return "test";
    }
}
