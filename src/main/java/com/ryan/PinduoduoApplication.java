package com.ryan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ryan.dao")
public class PinduoduoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PinduoduoApplication.class, args);
	}

}
