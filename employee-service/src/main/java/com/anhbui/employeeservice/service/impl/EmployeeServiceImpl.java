package com.anhbui.employeeservice.service.impl;

import com.anhbui.employeeservice.dto.APIResponseDto;
import com.anhbui.employeeservice.dto.DepartmentDto;
import com.anhbui.employeeservice.dto.EmployeeDto;
import com.anhbui.employeeservice.dto.OrganizationDto;
import com.anhbui.employeeservice.entity.Employee;
import com.anhbui.employeeservice.mapper.EmployeeMapper;
import com.anhbui.employeeservice.repository.EmployeeRepository;
import com.anhbui.employeeservice.service.EmployeeService;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER =  LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private EmployeeRepository employeeRepository;

    //    private RestTemplate restTemplate;
    private WebClient webClient;
//    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee saveDEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(saveDEmployee);
    }

//    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {

        LOGGER.info("inside getEmployeeById(Long employeeId)");
        Employee employee = employeeRepository.findById(employeeId).get();

//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://DEPARTMENT-SERVICE/api/departments/" + employee.getDepartmentCode(),
//                DepartmentDto.class);
//
//        DepartmentDto departmentDto = responseEntity.getBody();

        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
        OrganizationDto organizationDto = webClient.get()
                .uri("http://localhost:8083/api/organizations/"+ employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();
//        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        apiResponseDto.setOrganization(organizationDto);
        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long employeeId, Exception exception) {
        Employee employee = employeeRepository.findById(employeeId).get();
        LOGGER.info("inside getDefaultDepartment(Long employeeId)");

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("RED Department");
        departmentDto.setDepartmentCode("R0001");
        departmentDto.setDepartmentDescription("Research and Development Department");


        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }

}
