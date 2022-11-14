package com.kirby.lookthis.user.controller;

import com.kirby.lookthis.user.dto.UserDto;
import com.kirby.lookthis.user.entity.User;
import com.kirby.lookthis.user.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping
public class UserController {

	private final UserService userService;

	@PostMapping(value = "/getUser", produces = "application/json")
	public User getUser(@RequestBody UserDto userDto) {
		log.info(userDto.toString());
		return userService.getUser(userDto);
	}

	@PutMapping(value="/insertUser", produces = "application/json")
	public void insertUser(@RequestBody UserDto userDto) {
		log.info(userDto.toString());
		userService.insertUser(userDto);
	}
}
