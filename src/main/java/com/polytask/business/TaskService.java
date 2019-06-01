package com.polytask.business;

/*
* Equivalent a publicationService dans le projet polyNet
* Si autre proposition pour le nom, je suis preneur
* */

public interface TaskService {
    void add(Task task);
    void modify(int task_id,String content);
    void delete(int task_id);
    void check(int task_id);
}
