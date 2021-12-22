package ru.org.RestGifApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RestGifApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestGifApiApplication.class, args);
	}

}
