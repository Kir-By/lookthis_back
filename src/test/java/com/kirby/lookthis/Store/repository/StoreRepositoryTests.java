package com.kirby.lookthis.Store.repository;

import com.kirby.lookthis.store.entity.Flyer;
import com.kirby.lookthis.store.entity.Store;
import com.kirby.lookthis.store.repository.FlyerRepository;
import com.kirby.lookthis.store.repository.StoreRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Log4j2
public class StoreRepositoryTests {

    @Autowired
    private StoreRepository storeRepository;

    @Test
    public void insertStoreTest() {
        Store store = Store.builder()
                .storeId(1)
                .address("종로3가")
                .authStatus(true)
                .authUser("관리자")
                .lat(31.123)
                .lng(123.31)
                .storeName("피앤티")
                .build();

        storeRepository.save(store);
    }
}
