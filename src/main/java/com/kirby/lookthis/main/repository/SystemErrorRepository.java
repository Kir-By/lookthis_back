package com.kirby.lookthis.main.repository;

import com.kirby.lookthis.main.entity.SystemError;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemErrorRepository extends JpaRepository<SystemError, Integer> {
}
