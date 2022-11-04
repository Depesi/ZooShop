package ua.bg.zooshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ua.bg.zooshop.config.SwaggerConfig;

@SpringBootApplication

@Import({SwaggerConfig.class})
public class ZooShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZooShopApplication.class, args);
	}

}
