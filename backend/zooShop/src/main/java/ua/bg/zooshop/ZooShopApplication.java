package ua.bg.zooshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ua.bg.zooshop.config.SwaggerConfig;

@SpringBootApplication

@Import({SwaggerConfig.class})
public class ZooShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZooShopApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/v1/**").allowedOrigins("http://localhost:4200/")
						.allowedMethods("GET","POST,","PUT","DELETE")
						.maxAge(3600)
						.allowedHeaders("Requestor-Type")
						.exposedHeaders("X-Get-Header");
			}
		};
	}
}
