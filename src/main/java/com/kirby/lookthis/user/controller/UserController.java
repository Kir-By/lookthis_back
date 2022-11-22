package com.kirby.lookthis.user.controller;

import com.kirby.lookthis.user.dto.UserDto;
import com.kirby.lookthis.user.entity.User;
import com.kirby.lookthis.user.service.UserService;
import lombok.RequiredArgsConstructor;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;


@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	private final UserService userService;

	@PostMapping(value = "user/getUser", produces = "application/json")
	public User getUser(@RequestBody UserDto userDto) {
		log.info(userDto.toString());
		return userService.getUser(userDto);
	}

	@PutMapping(value="user/saveUser", produces = "application/json")
	public void insertUser(@RequestBody UserDto userDto) {
		log.info(userDto.toString());
		userService.saveUser(userDto);
	}


}
