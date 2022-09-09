package com.vlad28x.app.repository.impl;

import com.vlad28x.app.entity.Project;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectRepositoryImpl extends AbstractRepository<Long, Project> {

    public ProjectRepositoryImpl() {
        super(Project.class);
    }

}
