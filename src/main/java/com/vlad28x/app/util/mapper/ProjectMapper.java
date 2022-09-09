package com.vlad28x.app.util.mapper;

import com.vlad28x.app.dto.ProjectRequestDto;
import com.vlad28x.app.dto.ProjectResponseDto;
import com.vlad28x.app.entity.Customer;
import com.vlad28x.app.entity.Project;

public final class ProjectMapper {

    private ProjectMapper() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static Project projectRequestDtoToProject(ProjectRequestDto dto) {
        Project project = new Project();
        if (dto.getCustomerId() != null) project.setCustomer(new Customer(dto.getCustomerId()));
        project.setName(dto.getName());
        project.setPayment(dto.getPayment());
        project.setStartDate(dto.getStartDate());
        return project;
    }

    public static ProjectResponseDto projectToProjectResponseDto(Project project) {
        ProjectResponseDto dto = new ProjectResponseDto();
        dto.setId(project.getId());
        if (project.getCustomer() != null) dto.setCustomerId(project.getCustomer().getId());
        dto.setName(project.getName());
        dto.setPayment(project.getPayment());
        dto.setStartDate(project.getStartDate());
        return dto;
    }

}
