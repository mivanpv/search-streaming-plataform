package com.unir.example.search_movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class SearchMoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchMoviesApplication.class, args);
	}

	@GetMapping(value = "/")
	public String home() {
		return "Eureka Client application";
	}
}
