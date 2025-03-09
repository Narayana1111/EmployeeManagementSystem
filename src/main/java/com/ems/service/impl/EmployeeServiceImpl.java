package com.ems.service.impl;

import com.ems.dto.EmployeeDto;
import com.ems.exceptions.ResourceNotFoundException;
import com.ems.mapper.EmployeeMapper;
import com.ems.repository.EmployeeRepository;
import com.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    EmployeeServiceImpl(EmployeeRepository employeeRepository,EmployeeMapper employeeMapper){
        this.employeeMapper=employeeMapper;
        this.employeeRepository=employeeRepository;
    }
    @Override
    public EmployeeDto createEmployee(EmployeeDto employee) {
        return employeeMapper.employeeToEmployeeDTO(employeeRepository.save(employeeMapper.employeeDtoToEmployee(employee)));
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        return employeeMapper.employeeToEmployeeDTO(employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not found with the id "+id)));
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeMapper.employeesToEmployeeDTOS(employeeRepository.findAll());
    }

    @Override
    public EmployeeDto updateEmp(Long id,EmployeeDto employeeDto) {
        employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee with the given id: "+id+ " doesn't exist"));
        employeeDto.setId(id) ;
        return employeeMapper.employeeToEmployeeDTO(employeeRepository.save(employeeMapper.employeeDtoToEmployee(employeeDto)));
    }

    @Override
    public void deleteEmp(Long id) {
        employeeRepository.deleteById(id);
    }
}
