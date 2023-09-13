package com.anhbui.employeeservice.service;

import com.anhbui.employeeservice.dto.APIResponseDto;
import com.anhbui.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
