package com.anhbui.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "Employee Dto information"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    @Schema(description = "employee id")
    private Long id;
    @Schema(description = "employee's first name")
    private String firstName;
    @Schema(description = "employee's last name")
    private String lastName;
    @Schema(description = "employee's email")
    private String email;
    @Schema(description = "department code which employee belong to")
    private String departmentCode;
    @Schema(description = "organization code which employee belong to")
    private String organizationCode;
}
