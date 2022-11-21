package com.kirby.lookthis.main.service;

import com.kirby.lookthis.store.repository.UserFlyerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Log4j2
@RequiredArgsConstructor
@Service
@EnableScheduling
public class ScheduleServiceImpl implements ScheduleService{

    private final UserFlyerRepository userFlyerRepository;

    @Scheduled(fixedDelay = 60000)
    @Transactional
    @Override
    public void removeUserFlyer() {
        log.info("removeUserFlyer");
        LocalDateTime localDateTime = LocalDateTime.now();
        userFlyerRepository.deleteUserFlyerByInitDateLessThan(localDateTime);
    }
}
