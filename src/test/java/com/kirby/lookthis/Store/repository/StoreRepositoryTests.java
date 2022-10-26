package com.kirby.lookthis.Store.repository;

import com.kirby.lookthis.store.entity.Flyer;
import com.kirby.lookthis.store.entity.Store;
import com.kirby.lookthis.store.repository.FlyerRepository;
import com.kirby.lookthis.store.repository.StoreRepository;
import com.kirby.lookthis.user.entity.User;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Log4j2
public class StoreRepositoryTests {

    @Autowired
    private StoreRepository storeRepository;

    @Test
    public void insertStoreTest() {
        User user = User.builder().userId("nsw2").build();
        Store store = Store.builder()
                .storeId(1)
                .user(user)
                .address("종로3가")
                .authStatus(true)
                .authUser("관리자")
                .lat(31.123)
                .lng(123.31)
                .storeName("피앤티")
                .build();

        storeRepository.save(store);
    }

    @Test
    public void getStoreTest() {
        List<Store> storeList = storeRepository.findAll();
        storeList.stream().forEach(store -> log.info(store.toString()));
    }
}
