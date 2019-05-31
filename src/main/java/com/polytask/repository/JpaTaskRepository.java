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


}
