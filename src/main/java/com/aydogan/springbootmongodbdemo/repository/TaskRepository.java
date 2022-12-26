package com.aydogan.springbootmongodbdemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.aydogan.springbootmongodbdemo.model.Task;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TaskRepository extends MongoRepository <Task, String> {
    List<Task> getTaskByImportance(int importance);

    @Query()
    List<Task> getTaskByAssignedUser(String assignedUser);
}
