package net.java.app.employee_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEmployeeDepartmentDTO {
  @Schema(description = "Employee Personal Details Object")
  private EmployeeDto employeeDto;

  @Schema(description = "Employee Department Details Object")
  private DepartmentDTO departmentDTO;

  @Schema(description = "Employee Organization Details Object")
  private OrganizationDto organizationDto;
}
