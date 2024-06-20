package net.java.app.employee_service.service;

import net.java.app.employee_service.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIFeignClient {

  @GetMapping("api/departments/{department-code}")
  DepartmentDTO getDepartment(@PathVariable("department-code") String departmentCode);
}
