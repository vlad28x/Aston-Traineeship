package com.vlad28x.app.entity;

import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends AbstractEntity<Long> {

    private Long account;
    @OneToOne
    @MapsId
    private User user;
    @OneToMany(mappedBy = "customer")
    private List<Project> projects = new ArrayList<>();

    public Customer() {
    }

    public Customer(Long id) {
        super(id);
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
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
