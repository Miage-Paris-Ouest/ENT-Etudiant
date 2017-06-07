package com.paris10.ent;

import com.paris10.ent.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
public class EntApplication {

	public static void main(String[] args) {

		SpringApplication.run(EntApplication.class, args);

	}
		@Bean
		CommandLineRunner init(StorageService storageService) {
			return (args) -> {
				storageService.deleteAll();
				storageService.init();
			};
		}
}
