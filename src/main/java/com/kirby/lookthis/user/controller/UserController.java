package com.kirby.lookthis.user.controller;

import com.kirby.lookthis.spot.dto.PointDto;
import com.kirby.lookthis.user.dto.UserDto;
import com.kirby.lookthis.user.entity.PointHistory;
import com.kirby.lookthis.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	private final UserService userService;

	@GetMapping(value = "user", produces = "application/json")
	public UserDto getUser(UserDto userDto) {
		log.info(userDto.toString());
		return userService.getUser(userDto);
	}

	@PutMapping(value="user", produces = "application/json")
	public void insertUser(@RequestBody UserDto userDto) {
		log.info(userDto.toString());
		userService.saveUser(userDto);
	}

	@GetMapping(value = "user/history/points", produces = "application/json")
	public List<PointHistory> getPointHistoryList(PointDto pointDto){
		return userService.getPointHistoryList(pointDto);
	}

	@PutMapping(value = "user/saveFcmToken", produces = "application/json")
	public String saveFcmToken(@RequestBody UserDto userDto){
		return userService.saveFcmToken(userDto);
	}
}
