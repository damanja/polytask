package com.polytask.repository;

import com.polytask.business.Task;

import java.util.List;

public interface TaskRepository {
    List findAll(String username);
    void add(Task task);

    void modify(int task_id, String content);
    void delete(int task_id);

    void check(int task_id);
}
