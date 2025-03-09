package com.ems.controller;

import com.ems.dto.EmployeeDto;
import com.ems.mapper.EmployeeMapper;
import com.ems.repository.EmployeeRepository;
import com.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper, EmployeeService employeeService) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.employeeService = employeeService;
    }
    @PostMapping
    public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto empDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(empDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAll() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> update(@PathVariable Long id, @RequestBody EmployeeDto employeeDto){
        return ResponseEntity.ok(employeeService.updateEmp(id,employeeDto));
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<String> delete(@PathVariable Long id){
        employeeService.deleteEmp(id);
        return ResponseEntity.ok("Successfully deleted");
    }
}
