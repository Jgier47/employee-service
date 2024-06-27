package net.java.app.employee_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.java.app.employee_service.dto.EmployeeDto;
import net.java.app.employee_service.dto.ResponseEmployeeDepartmentDTO;
import net.java.app.employee_service.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
    name = "Employee Service - Employee Controller",
    description = "Employee Controller exposes REST APIs for Employee Service")
@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

  private EmployeeService employeeService;

  @Operation(
      summary = "Save Employee REST API",
      description = "Save Employee REST API is used to save employee object in a database")
  @ApiResponse(responseCode = "201", description = "HTTP Status 201 Created")
  @PostMapping
  public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
    return new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
  }

  @Operation(
      summary = "Get Employee REST API",
      description = "Get Employee REST API is used to get Employee object from the database")
  @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
  @GetMapping("{employeeId}")
  public ResponseEntity<ResponseEmployeeDepartmentDTO> getEmployee(
      @PathVariable("employeeId") Long employeeId) {
    return new ResponseEntity<>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
  }
}
