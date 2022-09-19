package com.kirby.lookthis.store.repository;

import com.kirby.lookthis.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer> {
}
