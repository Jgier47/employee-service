package net.java.app.employee_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Organization DTO Model Information")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {

  private Long id;

  @Schema(description = "Organization Name")
  private String organizationName;

  @Schema(description = "Organization Description")
  private String organizationDescription;

  @Schema(description = "Organization Code")
  private String organizationCode;

  @Schema(description = "Organization creation date")
  private LocalDateTime createdDate;
}
