package net.java.app.employee_service.controller;

import lombok.AllArgsConstructor;
import net.java.app.employee_service.dto.EmployeeDto;
import net.java.app.employee_service.dto.ResponseEmployeeDepartmentDTO;
import net.java.app.employee_service.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

  private EmployeeService employeeService;

  @PostMapping
  public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
    return new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
  }

  @GetMapping("{employeeId}")
  public ResponseEntity<ResponseEmployeeDepartmentDTO> getEmployee(
      @PathVariable("employeeId") Long employeeId) {
    return new ResponseEntity<>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
  }
}
