package net.java.app.employee_service.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import java.time.LocalDateTime;
import net.java.app.employee_service.dto.OrganizationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface APIOrganizationFeignClient {
  Logger LOGGER = LoggerFactory.getLogger(APIOrganizationFeignClient.class);

  @Retry(name = "ORGANIZATION-SERVICE")
  @CircuitBreaker(name = "ORGANIZATION-SERVICE", fallbackMethod = "getOrganizationByCodeFallback")
  @GetMapping("api/organizations/{organization-code}")
  OrganizationDto getOrganization(@PathVariable("organization-code") String organizationCode);

  default OrganizationDto getOrganizationByCodeFallback(
      String departmentCode, Throwable exception) {
    LOGGER.info("Searched organization code not found: " + departmentCode);
    LOGGER.info(exception.getLocalizedMessage());
    return new OrganizationDto(
        0L, "R&D", "R&D organization description", "RD14", LocalDateTime.now());
  }
}
