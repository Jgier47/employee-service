package net.java.app.employee_service.service;

import net.java.app.employee_service.dto.EmployeeDto;

public interface EmployeeService {
  EmployeeDto saveEmployee(EmployeeDto employeeDto);

  EmployeeDto getEmployeeById(Long employee);
}
