package com.anhbui.organizationservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Schema(description = "Organization dto to describe organization's information")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {
    @Schema(description = "Organization id")
    private Long id;
    @Schema(description = "Organization name")
    private String organizationName;
    @Schema(description = "Organization description")
    private String organizationDescription;
    @Schema(description = "Organization code")
    private String organizationCode;
    @Schema(description = "Organization created date")
    private LocalDateTime createdDate;
}
