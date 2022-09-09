package com.vlad28x.app.repository.impl;

import com.vlad28x.app.entity.AbstractEntity;
import com.vlad28x.app.repository.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class AbstractRepository<K extends Serializable, E extends AbstractEntity<K>> implements Repository<K, E> {

    protected final Class<E> clazz;

    @PersistenceContext
    protected EntityManager entityManager;

    public AbstractRepository(Class<E> clazz) {
        this.clazz = clazz;
    }

    @Override
    public E save(E entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public void delete(K id) {
        entityManager.remove(entityManager.find(clazz, id));
        entityManager.flush();
    }

    @Override
    public E update(E entity) {
        return entityManager.merge(entity);
    }

    @Override
    public Optional<E> findById(K id) {
        return Optional.ofNullable(entityManager.find(clazz, id));
    }

    @Override
    public List<E> findAll() {
        CriteriaQuery<E> criteria = entityManager.getCriteriaBuilder().createQuery(clazz);
        criteria.from(clazz);
        return entityManager.createQuery(criteria)
                .getResultList();
    }

}
