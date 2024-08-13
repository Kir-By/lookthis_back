package com.kirby.lookthis.main.repository;

import com.kirby.lookthis.main.entity.AwsInfo;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Log4j2
public class AwsInfoRepositoryTests {
    @Autowired
    private AwsInfoRepository awsInfoRepository;

    @Test
    @Transactional
    public void getAwsInfo() {
        AwsInfo awsInfo = awsInfoRepository.getAwsInfoByAwsInfoId(1);

        log.info(awsInfo.toString());
    }
}
