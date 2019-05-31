package com.polytask.repository;

import com.polytask.business.Task;

import java.util.List;

public interface TaskRepository {
    List findAll();
    void add(Task task);

    void modify(Task task);
}
