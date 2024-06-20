package net.java.app.employee_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DepartmentServiceInstanceLoadBalancer {
  @Bean
  DepartmentServiceInstanceListSuppler departmentServiceInstanceListSuppler() {
    return new DepartmentServiceInstanceListSuppler("department-service");
  }
}
