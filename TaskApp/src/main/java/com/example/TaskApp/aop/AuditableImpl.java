package com.example.TaskApp.aop;

import com.example.TaskApp.model.Task;
import com.example.TaskApp.repo.TaskRepo;

public class AuditableImpl implements Auditable {
    private String createdBy;

    @Override
    public void setCreatedBy(String user) {
        this.createdBy = user;
    }

    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public void audit(TaskRepo taskRepo, Task task) {
        if (createdBy != null && !createdBy.isEmpty() && task != null) {
            // Example: prepend createdBy into description before saving
            task.setDescription("[Created by " + createdBy + "] " + task.getDescription());
            taskRepo.save(task);
        }
    }
}
