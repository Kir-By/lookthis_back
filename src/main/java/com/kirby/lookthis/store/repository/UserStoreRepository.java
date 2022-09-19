package com.kirby.lookthis.store.repository;

import com.kirby.lookthis.store.entity.UserStore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStoreRepository extends JpaRepository<UserStore, Integer> {
}
