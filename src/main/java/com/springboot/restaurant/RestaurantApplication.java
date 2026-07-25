package com.springboot.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
//Tạm thời bỏ qua tự động cấu hình DB
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })

public class RestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

}
