package com.example.TaskApp.aop;

import com.example.TaskApp.model.Task;
import com.example.TaskApp.repo.TaskRepo;

public interface Auditable {
    void setCreatedBy(String user);
    String getCreatedBy();

    // Hook: called whenever a Task is saved
    void audit(TaskRepo taskRepo, Task task);
}
