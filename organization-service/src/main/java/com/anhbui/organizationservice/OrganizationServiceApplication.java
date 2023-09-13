package com.anhbui.organizationservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Organization Service REST APIs",
				description = "Organization Service REST APIs",
				version = "v1.0",
				contact = @Contact(
						name = "anh bui",
						email = "buihoangducanh0987@gmail.com",
						url = "buihoangducanh0987@gmail.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "buihoangducanh0987@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Organization Service REST APIs",
				url = "buihoangducanh0987@gmail.com"
		)

)
@SpringBootApplication
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
