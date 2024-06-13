package net.java.app.employee_service.service.impl;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.java.app.employee_service.dto.EmployeeDto;
import net.java.app.employee_service.entity.Employee;
import net.java.app.employee_service.exceptions.EmployeeAlreadyExistsException;
import net.java.app.employee_service.exceptions.ResourceNotFoundException;
import net.java.app.employee_service.mapper.EmployeeMapper;
import net.java.app.employee_service.repository.EmployeeRepository;
import net.java.app.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired private EmployeeRepository employeeRepository;
  @Autowired private EmployeeMapper employeeMapper;

  @Override
  public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
    Optional<Employee> employee = employeeRepository.findByEmail(employeeDto.getEmail());
    if (employee.isPresent())
      throw new EmployeeAlreadyExistsException(
          String.format("Employee with email %s already exists", employeeDto.getEmail()));

    return employeeMapper.mapToEmployeeDto(
        employeeRepository.save(employeeMapper.mapToEmployee(employeeDto)));
  }

  @Override
  public EmployeeDto getEmployeeById(Long employeeId) {
    Employee employee =
        employeeRepository
            .findById(employeeId)
            .orElseThrow(
                () ->
                    new ResourceNotFoundException("Employee", "employeeID", employeeId.toString()));

    return employeeMapper.mapToEmployeeDto(employee);
  }
}
