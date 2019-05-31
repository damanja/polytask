package com.polytask.business;

import com.polytask.repository.TaskRepository;

import java.util.List;

public class FeedServiceImpl implements FeedService {

    private TaskRepository taskRepository;

    public FeedServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public List fetchAll(String username) {
        return taskRepository.findAll(username);
    }


}
