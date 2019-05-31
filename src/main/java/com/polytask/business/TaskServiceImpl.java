package com.polytask.business;

import com.polytask.repository.TaskRepository;

public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public void add(Task task) {
        taskRepository.add(task);
    }

    @Override
    public void modify(int task_id, String content) {
        taskRepository.modify(task_id,content);
    }
}
