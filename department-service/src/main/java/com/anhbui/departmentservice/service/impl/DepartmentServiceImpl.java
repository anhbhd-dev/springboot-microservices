package com.anhbui.departmentservice.service.impl;

import com.anhbui.departmentservice.mapper.DepartmentMapper;
import lombok.AllArgsConstructor;
import com.anhbui.departmentservice.dto.DepartmentDto;
import com.anhbui.departmentservice.entity.Department;
import com.anhbui.departmentservice.repository.DepartmentRepository;
import com.anhbui.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        // convert department dto to department jpa entity
        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        return DepartmentMapper.mapToDepartmentDto(department);
    }
}
