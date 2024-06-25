package net.java.app.employee_service.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import net.java.app.employee_service.dto.DepartmentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIDepartmentFeignClient {
  Logger LOGGER = LoggerFactory.getLogger(APIDepartmentFeignClient.class);

  @Retry(name = "DEPARTMENT-SERVICE")
  @CircuitBreaker(name = "DEPARTMENT-SERVICE", fallbackMethod = "getDepartmentByCodeFallback")
  @GetMapping("api/departments/{department-code}")
  DepartmentDTO getDepartment(@PathVariable("department-code") String departmentCode);

  default DepartmentDTO getDepartmentByCodeFallback(String departmentCode, Throwable exception) {
    LOGGER.info("Searched department code not found: " + departmentCode);
    LOGGER.info(exception.getLocalizedMessage());
    return new DepartmentDTO(0L, "R&D", "R&D department", "RD13");
  }
}
