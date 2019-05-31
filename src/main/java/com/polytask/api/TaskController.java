package com.polytask.api;

import com.polytask.business.FeedService;
import com.polytask.business.Task;
import com.polytask.business.TaskService;
import com.polytask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/modifyTask/{task_id}")
    public void modifyTask(@PathVariable("task_id") int task_id,@RequestBody String content){
        taskService.modify(task_id, content);
    }

    @DeleteMapping("/deleteTask/{task_id}")
    public void deleteTask(@PathVariable("task_id") int task_id){
        taskService.delete(task_id);
    }

}
