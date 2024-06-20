package net.java.app.employee_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEmployeeDepartmentDTO {
  private EmployeeDto employeeDto;
  private DepartmentDTO departmentDTO;
}
