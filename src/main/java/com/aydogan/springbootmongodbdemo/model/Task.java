package com.aydogan.springbootmongodbdemo.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;



import java.time.LocalDateTime;



@Document(collection = "taskList")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Task {
    @Id
    private String taskId;
    private String taskTitle;
    private String taskDescription;
    private int importance;
    private String assignedUser;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUpdate;

}
