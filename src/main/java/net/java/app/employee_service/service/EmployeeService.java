package net.java.app.employee_service.service;

import net.java.app.employee_service.dto.EmployeeDto;
import net.java.app.employee_service.dto.ResponseEmployeeDepartmentDTO;

public interface EmployeeService {
  EmployeeDto saveEmployee(EmployeeDto employeeDto);

  ResponseEmployeeDepartmentDTO getEmployeeById(Long employee);
}
