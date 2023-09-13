package com.anhbui.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
        info = @Info(title = "Department Service REST APIs",
        description = "Department service rest api docs",
        version = "v1.0",
        contact = @Contact(
                name = "Anh bui",
                email = "buihoangducanh0978@gmail.com",
                url = "https://www.facebook.com/ducanh.buihoang/"
        ),
        license = @License(
                name = "Apache 2.0",
                url = "https://www.facebook.com/ducanh.buihoang/")),
        externalDocs = @ExternalDocumentation(
                description = "Department service docs",
                url = "https://www.facebook.com/ducanh.buihoang/"
        )
)
@SpringBootApplication
public class DepartmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentServiceApplication.class, args);
    }

}
