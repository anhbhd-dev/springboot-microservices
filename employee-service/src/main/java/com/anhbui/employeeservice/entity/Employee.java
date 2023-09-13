package com.anhbui.employeeservice.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "Employee entity information"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Schema(description = "employee id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(description = "employee's first name")
    private String firstName;
    @Schema(description = "employee's last name")
    private String lastName;
    @Schema(description = "employee's email")
    @Column(nullable = false, unique = true)
    private String email;
    @Schema(description = "department code which employee belong to")
    private String departmentCode;
    @Schema(description = "organization code which employee belong to")
    private String organizationCode;
}
