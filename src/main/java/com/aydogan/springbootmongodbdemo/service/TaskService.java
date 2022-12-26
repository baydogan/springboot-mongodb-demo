package com.aydogan.springbootmongodbdemo.service;

import com.aydogan.springbootmongodbdemo.repository.TaskRepository;
import com.aydogan.springbootmongodbdemo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public List<Task> findAllTasks(){
        return repository.findAll();
    }

    public Task addTask(Task task){
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        task.setLastUpdate(LocalDateTime.now());
        return repository.save(task);
    }

    public Task getTaskById(String taskId) {
        return repository.findById(taskId).get();
    }

    public List<Task> getTaskByAssignedUser(String assignedUser){
        return repository.getTaskByAssignedUser(assignedUser);
    }

    public List<Task> getTaskByImportance(int importance){
        return repository.getTaskByImportance(importance);
    }

    public String deleteTask(String taskId){
        repository.deleteById(taskId);
        return taskId + " has been deleted";
    }
}
