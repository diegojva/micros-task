package com.nttdata.escuela.autor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AutorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutorApplication.class, args);
	}

}
