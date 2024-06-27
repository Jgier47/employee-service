package net.java.app.employee_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Employee DTO Model Information")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
  private Long id;

  @Schema(description = "Employee First Name")
  private String firstName;

  @Schema(description = "Employee Last Name")
  private String lastName;

  @Schema(description = "Employee Email")
  private String email;

  @Schema(description = "Employee Department Code")
  private String departmentCode;

  @Schema(description = "Employee Organization Code")
  private String organizationCode;
}
