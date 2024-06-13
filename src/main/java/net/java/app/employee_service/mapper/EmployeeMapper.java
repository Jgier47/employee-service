package net.java.app.employee_service.mapper;

import net.java.app.employee_service.dto.EmployeeDto;
import net.java.app.employee_service.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

  EmployeeDto mapToEmployeeDto(Employee employee);

  Employee mapToEmployee(EmployeeDto employeeDto);
}
