package com.kirby.lookthis.user.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Log4j2
public class UserController {

	@PostMapping(value="/")
	public void postMethodName() {
		log.info("test");
		
		return;
	}
	
	
}
