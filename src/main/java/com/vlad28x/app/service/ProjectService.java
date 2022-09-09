package com.vlad28x.app.service;

import com.vlad28x.app.dto.EmployeeRequestDto;
import com.vlad28x.app.dto.EmployeeResponseDto;
import com.vlad28x.app.dto.ProjectRequestDto;
import com.vlad28x.app.dto.ProjectResponseDto;

import java.util.List;

public interface ProjectService {

    ProjectResponseDto getById(Long id);

    List<ProjectResponseDto> getAll();

    ProjectResponseDto create(ProjectRequestDto newProject);

    ProjectResponseDto update(Long id, ProjectRequestDto newProject);

    void delete(Long id);

}
