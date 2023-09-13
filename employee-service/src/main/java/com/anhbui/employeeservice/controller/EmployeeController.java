package com.anhbui.employeeservice.controller;

import com.anhbui.employeeservice.dto.APIResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import com.anhbui.employeeservice.dto.EmployeeDto;
import com.anhbui.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Employee Service - EmployeeController"
        , description = "EmployeeController Exposes REST API for employee service")
@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    // Build Save Employee REST API
    @Operation(
            summary = "save employee rest api",
            description = "save employee object to database"

    )
    @ApiResponse(
            responseCode = "201",
            description = "Http status 201 created"
    )
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // Build Get Employee REST API
    @Operation(
            summary = "get employee by id",
            description = "rest api to retrieve an employee object from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "http status code 200 ok"
    )
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId) {
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }
}
