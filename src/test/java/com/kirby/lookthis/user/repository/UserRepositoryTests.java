package com.kirby.lookthis.user.repository;

import com.kirby.lookthis.user.entity.LoginHistory;
import com.kirby.lookthis.user.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LoginHistoryRepository loginHistoryRepository;

	@Test
	public void insertUserTest() {
		User user = User.builder()
		.userId("nsw2")
		.password("1234")
		.accesstoken("123456789")
		.auth("ROLE_ADMIN")
		.build();

		userRepository.save(user);
	}

	@Test
	public void getUserTest() {
		User user = User.builder()
				.userId("nsw2")
				.build();

		User user2 = userRepository.findByUserId(user.getUserId());
		log.info(user2.toString());
	}

	@Test
	public void saveLoginHistory() {

		LoginHistory loginHistory = LoginHistory
				.builder()
				.status("Login")
				.platform("Naver")
				.service("http://lookthis.co.kr")
				.build();
		loginHistoryRepository.save(loginHistory);
	}

	
}
