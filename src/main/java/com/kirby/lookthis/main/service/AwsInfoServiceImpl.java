package com.kirby.lookthis.main.service;

import com.kirby.lookthis.main.entity.AwsInfo;
import com.kirby.lookthis.main.repository.AwsInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
@EnableScheduling
public class AwsInfoServiceImpl implements AwsInfoService{
    private final AwsInfoRepository awsInfoRepository;

    @Override
    public AwsInfo getAwsInfoByAwsInfoId() {
        return awsInfoRepository.getAwsInfoByAwsInfoId(1);
    }
}
