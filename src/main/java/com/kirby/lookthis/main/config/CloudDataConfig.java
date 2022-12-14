package com.kirby.lookthis.main.config;

import lombok.extern.log4j.Log4j2;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.cloud.service.ServiceInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Profile("cloud")
@Log4j2
@ServiceScan
@Configuration
public class CloudDataConfig extends AbstractCloudConfig {

    @Value("${db.mysql.servicename}")
    private String mysqlServiceName;

    private String cubridJdbcUrl;

    @Bean(name = "dsMysql")
    @Primary
    public DataSource mysqlDataSource() {
        CloudFactory cloudFactory = new CloudFactory();
        Cloud cloud = cloudFactory.getCloud();
        ServiceInfo serviceInfo = cloud.getServiceInfo(mysqlServiceName);
        String serviceId = serviceInfo.getId();

        String vcap_services = System.getenv("VCAP_SERVICES");
        log.info("==================================");
        log.info(vcap_services);
        JSONObject jsonObj = JSONObject.fromObject(vcap_services);
        JSONArray userPro = jsonObj.getJSONArray("mysql-on-demand");
        String username = null;
        String password = null;

        for (int i = 0; i < userPro.size(); i++) {
            JSONObject service_object = JSONObject.fromObject(userPro.get(i));
            JSONObject credObj = service_object.getJSONObject("credentials");
            username = credObj.getString("username");
            cubridJdbcUrl = username;
            password = credObj.getString("password");
            cubridJdbcUrl += ":" + password;
            cubridJdbcUrl += ":" + credObj.getString("hostname");
            cubridJdbcUrl += ":" + credObj.getString("port");
        }
        log.info(cubridJdbcUrl);

        DataSource dataSource = DataSourceBuilder.create()
                .url("jdbc:mariadb://10.1.2.90:13306/oxoyvt9ppzr3ozzy4mvm")
                .username(username)
                .password(password)
                .build();
        return dataSource;

    }

    @Bean(name = "jdbcMysql")
    @Autowired
    public JdbcTemplate mysqlJdbcTemplate(@Qualifier("dsMysql") DataSource dsSlave) {
        return new JdbcTemplate(dsSlave);
    }
}
