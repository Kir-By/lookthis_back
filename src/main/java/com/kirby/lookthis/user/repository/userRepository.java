package com.kirby.lookthis.user.repository;

import com.kirby.lookthis.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User, String>{
	
}
