package com.trip;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@EnableDubbo
/* @ImportResource(locations = {"application-dubbo-provider.xml"}) */
@MapperScan("com.trip.persist.mapper")
public class TripAccountServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(TripAccountServiceApplication.class, args);
	}

}
