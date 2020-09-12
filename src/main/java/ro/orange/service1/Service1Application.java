package ro.orange.service1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableDiscoveryClient
@SpringBootApplication
public class Service1Application {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("GET", "POST", "PUT", "DELETE")
						.allowedOrigins("*")
						.allowedHeaders("*")
						.exposedHeaders("X-Total-Count", "Link", "Access-Control-Allow-Origin");
			}
		};
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	public static void main(String[] args) {
		SpringApplication.run(Service1Application.class, args);
	}

}
