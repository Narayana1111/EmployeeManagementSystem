package com.ems.service;

import ch.qos.logback.classic.model.processor.LogbackClassicDefaultNestedComponentRules;
import com.ems.dto.EmployeeDto;
import com.ems.entity.Employee;

import java.util.List;

public interface EmployeeService {
EmployeeDto createEmployee(EmployeeDto employee);
EmployeeDto getEmployeeById(Long id);

List<EmployeeDto> getAllEmployees();

EmployeeDto updateEmp(Long id,EmployeeDto employeeDto);
void deleteEmp(Long id);
}
