package com.polytask.api;

import com.polytask.business.FeedService;
import com.polytask.business.Task;
import com.polytask.business.TaskService;
import com.polytask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskService taskService;

    @Autowired
    FeedService feedService;

    @GetMapping("/taskSet")
    public List<Task> getTask(){
        return feedService.fetchAll();
    }

    @PostMapping("/addTask")
    public void addTask(@RequestBody String content){
        taskService.add(new Task(content));
    }
}
