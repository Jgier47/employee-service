package net.java.app.employee_service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Department DTO Model Information")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepartmentDTO {
  private Long id;

  @Schema(description = "Department Name")
  private String departmentName;

  @Schema(description = "Department Description")
  private String departmentDescription;

  @Schema(description = "Department Code")
  private String departmentCode;
}
