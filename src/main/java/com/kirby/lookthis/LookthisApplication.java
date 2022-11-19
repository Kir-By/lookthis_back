package com.kirby.lookthis;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@SpringBootApplication
@Log4j2
@EnableEncryptableProperties
@EnableJpaRepositories("com.kirby.lookthis.*.repository")
@EntityScan("com.kirby.lookthis.*.entity")
public class LookthisApplication{

	@Autowired
	DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(LookthisApplication.class, args);
	}

}
