package com.kirby.lookthis;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@SpringBootApplication
@EnableEncryptableProperties
@EnableJpaRepositories("com.kirby.lookthis.*.repository")
@EntityScan("com.kirby.lookthis.*.entity")
public class LookthisApplication implements CommandLineRunner {
	@Autowired
	private DataSource dataSource;

	@Override
	public void run(String... args) throws Exception {
		org.apache.tomcat.jdbc.pool.DataSource tomcat = (org.apache.tomcat.jdbc.pool.DataSource) dataSource;
		System.err.println(tomcat.getDriverClassName() + ", " + tomcat.getUrl());
	}
	public static void main(String[] args) {
		SpringApplication.run(LookthisApplication.class, args);
	}

}
