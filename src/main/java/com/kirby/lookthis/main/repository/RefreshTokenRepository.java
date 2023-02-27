package com.kirby.lookthis.main.repository;

import com.kirby.lookthis.main.entity.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String > {
}
