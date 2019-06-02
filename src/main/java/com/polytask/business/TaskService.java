package com.polytask.business;

public interface TaskService {
    void add(Task task);
    void modify(int task_id,String content);
    void delete(int task_id);
    void check(int task_id);
}
