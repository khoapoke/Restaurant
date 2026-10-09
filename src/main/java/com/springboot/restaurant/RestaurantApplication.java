package com.springboot.restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletWebServerApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;


@SpringBootApplication
public class RestaurantApplication {

	private static final Logger logger = LoggerFactory.getLogger(RestaurantApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void logApplicationLinks(ApplicationReadyEvent event) {
		ServletWebServerApplicationContext applicationContext =
				(ServletWebServerApplicationContext) event.getApplicationContext();
		Environment environment = applicationContext.getEnvironment();
		int port = applicationContext.getWebServer().getPort();
		String contextPath = environment.getProperty("server.servlet.context-path", "");
		String baseUrl = "http://localhost:" + port + contextPath;

		logger.info("""

				Application is ready:
				Swagger UI:   {}
				OpenAPI JSON: {}
				""",
				baseUrl + "/swagger-ui/index.html",
				baseUrl + "/v3/api-docs");
	}

}
