package com.polytask.repository;

import com.polytask.business.Task;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class JpaTaskRepository implements TaskRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Task> findAll() {
        Query query = entityManager.createQuery("SELECT s FROM Task s");
        return query.getResultList();
    }

    @Override
    public void add(Task task) {
        entityManager.persist(task);
    }

    @Override
    public void modify(Task task) {

    }

}
