package com.kristal.pm;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PreDestroy;
import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
@Slf4j
public class Application {

	public static void main(String[] args) {
		MDC.put("event", "bootstrap");
		MDC.put("applicationName", "pm");
		log.info("Starting portfolio-mgmt-service.....................................");
		SpringApplication.run(Application.class, args);
		log.info("portfolio management service started");
		MDC.remove("event");
	}

	@PreDestroy
	public void preDestroy() { MDC.put("event", "application-stopped"); }

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.kristal.pm.controllers"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"Portfolio Management Service",
				"PM Rest Service API",
				"API V1",
				"T & C",
				new Contact("Kristal", "www.kristal.ai", "kristal.ai"),
				"API", "API URL", Collections.emptyList());
	}

}
