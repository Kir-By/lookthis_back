package com.kirby.lookthis.store.repository;

import com.kirby.lookthis.store.entity.Store;
import com.kirby.lookthis.user.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Integer> {

    @Query("select s from Store s " +
            "where s.user.userId = :#{#userDto.userId} ")
    List<Store> getStoreList(@Param("userDto")UserDto userDto);

    @Query("select s from Store s " +
            "left join Flyer f on f.storeId = s.storeId " +
            "where f.flyerId = :flyerId")
    Store getStoreByFlyerId(Integer flyerId);
}
