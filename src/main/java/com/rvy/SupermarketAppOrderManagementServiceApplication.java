package com.rvy;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.function.Predicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@SpringBootApplication
@EnableOpenApi
@EnableJpaRepositories
@EntityScan("com.rvy.entity")
//@EnableEurekaClient
public class SupermarketAppOrderManagementServiceApplication {
	/**
     * Main method
     * @param args
     */
	public static void main(String[] args) {
		SpringApplication.run(
		SupermarketAppOrderManagementServiceApplication.class,
				args);
	}

	@Bean
	public Docket openApiPetStore() {
		return new Docket(DocumentationType.OAS_30)
				.groupName("open-api-order-management-service")
				.select()
				.paths(omsPaths())
				.build();
	}

	private Predicate<String> omsPaths() {
		return regex(".*/v1/.*");
	}
}
