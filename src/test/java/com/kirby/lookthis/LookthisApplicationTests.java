package com.kirby.lookthis;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class LookthisApplicationTests {
	private final static String key= "kirBy";
	private final static String algorithm="PBEWithMD5AndDES";
	private final static String cnt = "1000";
	private final static String poolSize = "1";
	private final static String base64 = "base64";

	@Test
	void contextLoads() {
		log.info("test");
	}

	@Test
	void jasyptTest() {
		SimpleStringPBEConfig config = new SimpleStringPBEConfig();
		config.setPassword(key);
		config.setAlgorithm(algorithm);
		config.setKeyObtentionIterations(cnt);
		config.setPoolSize(poolSize);
		config.setStringOutputType(base64);

		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
		encryptor.setConfig(config);

		log.info("==================================");
		log.info(encryptor.encrypt("${spring.security.oauth2.client.provider.naver.user-info-uri}"));
	}
}
