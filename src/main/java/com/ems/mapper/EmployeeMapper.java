package com.ems.mapper;

import com.ems.dto.EmployeeDto;
import com.ems.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDto employeeToEmployeeDTO(Employee employee);
    @Mapping(target = "id", ignore=true)
    Employee employeeDtoToEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> employeesToEmployeeDTOS(List<Employee> employees);
}
