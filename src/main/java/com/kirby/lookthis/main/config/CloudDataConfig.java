package com.kirby.lookthis.main.config;

import lombok.extern.log4j.Log4j2;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.cloud.service.ServiceInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Profile("cloud")
@Log4j2
@ServiceScan
public class CloudDataConfig extends AbstractCloudConfig {

    @Value("${db.mysql.servicename}")
    private String mysqlServiceName;

    private String cubridJdbcUrl;

    @Value("${mongodb.service.name}")
    private String mongoServiceName;

    @Value("${redis.service.name}")
    private String redisServiceName;

    @Value("${rabbitmq.service.name}")
    private String rabbitServiceName;

    @Bean(name = "dsMysql")
    @Primary
    DataSource mysqlDataSource() {

        CloudFactory cloudFactory = new CloudFactory();
        Cloud cloud = cloudFactory.getCloud();
        ServiceInfo serviceInfo = cloud.getServiceInfo(mysqlServiceName);
        String serviceId = serviceInfo.getId();
        return cloud.getServiceConnector(serviceId, DataSource.class, null);

    }

    @Bean(name = "jdbcMysql")
    @Autowired
    public JdbcTemplate mysqlJdbcTemplate(@Qualifier("dsMysql") DataSource dsSlave) {
        return new JdbcTemplate(dsSlave);
    }

    @Bean(name = "dsCubrid")
    public DataSource cubridDataSource() {
        try {
            String vcap_services = System.getenv("VCAP_SERVICES");
            log.info(vcap_services);
            JSONObject jsonObj = JSONObject.fromObject(vcap_services);
            JSONArray userPro = jsonObj.getJSONArray("mysql-on-demand");
            for (int i = 0; i < userPro.size(); i++) {
                JSONObject service_object = JSONObject.fromObject(userPro.get(i));
                JSONObject credObj = service_object.getJSONObject("credentials");
                cubridJdbcUrl = credObj.getString("jdbcurl");
            }

            return new SimpleDriverDataSource(cubrid.jdbc.driver.CUBRIDDriver.class.newInstance(), cubridJdbcUrl);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean(name = "jdbcCubrid")
    @Autowired
    public JdbcTemplate cubridJdbcTemplate(@Qualifier("dsCubrid") DataSource dsSlave) {
        return new JdbcTemplate(dsSlave);
    }
}
