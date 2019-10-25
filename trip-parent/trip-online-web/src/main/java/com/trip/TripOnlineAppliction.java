package com.trip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
/** 映入dubbo的xml配置文件
@ImportResource(locations = {"application-dubbo-consumer.xml"})
 */
public class TripOnlineAppliction {
public static void main(String[] args) {
	SpringApplication.run(TripOnlineAppliction.class, args);
}
}
