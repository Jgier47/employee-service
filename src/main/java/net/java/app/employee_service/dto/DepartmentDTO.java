package net.java.app.employee_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
  private Long id;
  private String departmentName;
  private String departmentDescription;
  private String departmentCode;
}
