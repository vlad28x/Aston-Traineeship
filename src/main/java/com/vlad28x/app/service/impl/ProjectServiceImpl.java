package com.vlad28x.app.service.impl;

import com.vlad28x.app.dto.ProjectRequestDto;
import com.vlad28x.app.dto.ProjectResponseDto;
import com.vlad28x.app.entity.Project;
import com.vlad28x.app.entity.User;
import com.vlad28x.app.exception.NotFoundException;
import com.vlad28x.app.repository.impl.ProjectRepositoryImpl;
import com.vlad28x.app.service.ProjectService;
import com.vlad28x.app.util.mapper.ProjectMapper;
import com.vlad28x.app.util.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepositoryImpl projectRepository;

    public ProjectServiceImpl(ProjectRepositoryImpl projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectResponseDto getById(Long id) {
        return ProjectMapper.projectToProjectResponseDto(projectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Project with ID %s not found", id))));
    }

    @Override
    public List<ProjectResponseDto> getAll() {
        return projectRepository.findAll().stream()
                .map(ProjectMapper::projectToProjectResponseDto).collect(Collectors.toList());
    }

    @Override
    public ProjectResponseDto create(ProjectRequestDto newProject) {
        return ProjectMapper.projectToProjectResponseDto(
                projectRepository.save(ProjectMapper.projectRequestDtoToProject(newProject))
        );
    }

    @Override
    public ProjectResponseDto update(Long id, ProjectRequestDto newProject) {
        Project project = ProjectMapper.projectRequestDtoToProject(newProject);
        project.setId(id);
        return ProjectMapper.projectToProjectResponseDto(
                projectRepository.update(ProjectMapper.projectRequestDtoToProject(newProject))
        );
    }

    @Override
    public void delete(Long id) {
        projectRepository.delete(id);
    }
}
