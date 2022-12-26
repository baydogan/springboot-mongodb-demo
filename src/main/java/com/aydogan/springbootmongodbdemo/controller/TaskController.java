package com.aydogan.springbootmongodbdemo.controller;

import com.aydogan.springbootmongodbdemo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.aydogan.springbootmongodbdemo.model.Task;

import java.util.List;

@RestController
@RequestMapping("/tasks")

public class TaskController {
    @Autowired
    private TaskService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task){
        return service.addTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return service.findAllTasks();
    }

    @GetMapping("/{taskId}")
    public Task getTask(@PathVariable String taskId){
        return service.getTaskById(taskId);
    }

    @GetMapping("/assignedUser")
    public List<Task> getTaskByAssignedUser(String assignedUser){
        return service.getTaskByAssignedUser(assignedUser);
    }

    @GetMapping("/importance/{importance}")
    public List<Task> getTaskByImportance(@PathVariable int importance){
        return service.getTaskByImportance(importance);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable String taskId){
        return service.deleteTask(taskId);
    }

    @PutMapping
    public Task updateTask(@RequestBody Task task){
        return service.updateExistingTask(task);
    }

}
