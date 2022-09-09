package com.vlad28x.app.repository.impl;

import com.vlad28x.app.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends AbstractRepository<Long, User> {

    public UserRepositoryImpl() {
        super(User.class);
    }

}
