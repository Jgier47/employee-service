package net.java.app.employee_service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@OpenAPIDefinition(
    info =
        @Info(
            title = "Employee Service REST APIs",
            description = "Employee Service REST APIs Documentation",
            version = "v1.0"))
@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(EmployeeServiceApplication.class, args);
  }
}
