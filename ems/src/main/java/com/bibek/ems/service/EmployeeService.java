package com.bibek.ems.service;

import com.bibek.ems.dto.EmployeeDto;
import com.bibek.ems.entity.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);


    void deleteEmployee(Long employeeId);
}
