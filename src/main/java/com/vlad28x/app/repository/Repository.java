package com.vlad28x.app.repository;

import com.vlad28x.app.entity.AbstractEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface Repository<K extends Serializable, E extends AbstractEntity<K>> {

    E save(E entity);

    E update(E entity);

    void delete(K id);

    Optional<E> findById(K id);

    List<E> findAll();

}
