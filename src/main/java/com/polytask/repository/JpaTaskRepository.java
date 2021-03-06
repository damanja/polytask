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
    public List<Task> findAll(String username) {
        Query query = entityManager.createQuery("SELECT t FROM Task t where t.username=?1");
        query.setParameter(1, username);
        return query.getResultList();
    }

    @Override
    public void add(Task task) {
        entityManager.persist(task);
    }

    @Override
    public void modify(int task_id, String content) {
        Task task = entityManager.find(Task.class, task_id);
//        entityManager.getTransaction().begin();
        task.setContent(content);
//        entityManager.getTransaction().commit();
//        entityManager.close();
        entityManager.merge(task);
    }

    @Override
    public void delete(int task_id) {
        Task task = entityManager.find(Task.class, task_id);
        entityManager.remove(task);
    }

    @Override
    public void check(int task_id) {
        Task task = entityManager.find(Task.class, task_id);
//        entityManager.getTransaction().begin();
        int i = task.getDone();
        if (i==0) task.setDone(1);
        else task.setDone(0);
//        entityManager.getTransaction().commit();
//        entityManager.close();
        entityManager.merge(task);
    }
}
