package com.vlad28x.app.entity;

import com.vlad28x.app.entity.enums.Position;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee extends AbstractEntity<Long> {

    @Enumerated(value = EnumType.STRING)
    private Position position;
    private LocalDate hireDate;
    @OneToOne
    @MapsId
    private User user;
    @ManyToMany(mappedBy = "employees")
    private List<Project> projects = new ArrayList<>();

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

}
