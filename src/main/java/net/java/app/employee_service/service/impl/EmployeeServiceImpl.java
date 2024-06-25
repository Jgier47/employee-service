package net.java.app.employee_service.service.impl;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.java.app.employee_service.dto.DepartmentDTO;
import net.java.app.employee_service.dto.EmployeeDto;
import net.java.app.employee_service.dto.ResponseEmployeeDepartmentDTO;
import net.java.app.employee_service.entity.Employee;
import net.java.app.employee_service.exceptions.EmployeeAlreadyExistsException;
import net.java.app.employee_service.exceptions.ResourceNotFoundException;
import net.java.app.employee_service.mapper.EmployeeMapper;
import net.java.app.employee_service.repository.EmployeeRepository;
import net.java.app.employee_service.service.APIFeignClient;
import net.java.app.employee_service.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
  @Autowired private EmployeeRepository employeeRepository;
  @Autowired private EmployeeMapper employeeMapper;
  @Autowired private APIFeignClient apiFeignClient;

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
  public ResponseEmployeeDepartmentDTO getEmployeeById(Long employeeId) {

    Employee employee =
        employeeRepository
            .findById(employeeId)
            .orElseThrow(
                () ->
                    new ResourceNotFoundException("Employee", "employeeID", employeeId.toString()));
    LOGGER.info(
        String.format(
            "Gathered employee details: Employee first name %s, Employee Last name %s, Employee email %s, Employee department code %s",
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmail(),
            employee.getDepartmentCode()));

    DepartmentDTO departmentDTO = apiFeignClient.getDepartment(employee.getDepartmentCode());

    return new ResponseEmployeeDepartmentDTO(
        employeeMapper.mapToEmployeeDto(employee), departmentDTO);
  }
}
