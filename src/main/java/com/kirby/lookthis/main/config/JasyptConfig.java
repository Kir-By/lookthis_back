package com.kirby.lookthis.main.config;

import lombok.extern.log4j.Log4j2;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Log4j2
public class JasyptConfig {
    private final static String key= "kirBy";
    private final static String algorithm="PBEWithMD5AndDES";
    private final static String cnt = "1000";
    private final static String poolSize = "1";
    private final static String base64 = "base64";

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(key);
        config.setAlgorithm(algorithm);
        config.setKeyObtentionIterations(cnt);
        config.setPoolSize(poolSize);
        config.setStringOutputType(base64);

        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setConfig(config);

        return encryptor;
    }
}
