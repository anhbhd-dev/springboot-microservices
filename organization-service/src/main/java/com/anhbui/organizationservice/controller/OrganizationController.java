package com.anhbui.organizationservice.controller;

import com.anhbui.organizationservice.dto.OrganizationDto;
import com.anhbui.organizationservice.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Organization service - OrganizationController",
        description = "Organization service - OrganizationController"
)
@AllArgsConstructor
@RestController
@RequestMapping("api/organizations")
public class OrganizationController {

    private OrganizationService organizationService;

    // Build Save Organization REST API
    @Operation(
            summary = "REST API to save organization object to database",
            description = "REST API to save organization object to database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http status code 201 created"
    )
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {
        OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(savedOrganization, HttpStatus.CREATED);
    }

    // Build Get Organization by Code REST API
    @Operation(
            summary = "REST API to get organization object from database",
            description = "REST API to get organization object from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http status code 200 Ok"
    )
    @GetMapping("{code}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode) {
        OrganizationDto organizationDto = organizationService.getOrganizationByCode(organizationCode);
        return ResponseEntity.ok(organizationDto);
    }
}
