package com.vlad28x.app.controller;


import com.vlad28x.app.dto.ProjectRequestDto;
import com.vlad28x.app.dto.ProjectResponseDto;
import com.vlad28x.app.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {


    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponseDto> getProjectById(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponseDto>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAll());
    }

    @PostMapping
    public ResponseEntity<ProjectResponseDto> createProject(@RequestBody ProjectRequestDto newProject) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.create(newProject));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponseDto> updateProject(@PathVariable Long id, @RequestBody ProjectRequestDto newProject) {
        return ResponseEntity.ok(projectService.update(id, newProject));
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.delete(id);
    }


}
