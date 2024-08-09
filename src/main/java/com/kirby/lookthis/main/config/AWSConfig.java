package com.kirby.lookthis.main.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.kirby.lookthis.main.entity.AwsInfo;
import com.kirby.lookthis.main.repository.AwsInfoRepository;
import com.kirby.lookthis.main.service.AwsInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AWSConfig {
    private final AwsInfoService awsInfoService;

    @Bean
    public AmazonS3Client amazonS3Client() {
        AwsInfo awsInfo = awsInfoService.getAwsInfoByAwsInfoId();
        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(awsInfo.getIamAccessKey(), awsInfo.getIamSecretKey());
        return (AmazonS3Client) AmazonS3ClientBuilder.standard()
                .withRegion(awsInfo.getRegion())
                .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
                .build();
    }
}
