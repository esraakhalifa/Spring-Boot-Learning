package com.example.TaskApp.service;

import com.example.TaskApp.model.Task;
import com.example.TaskApp.repo.TaskRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepo taskRepo;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    // Create a new task
    public Task createTask(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        return taskRepo.save(task);
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    // Get a task by ID
    public Optional<Task> getTaskById(Long id) {
        return taskRepo.findById(id);
    }

    // Update an existing task
    public Task updateTask(Long id, Task task) {
        return taskRepo.findById(id)
                .map(existing -> {
                    existing.setTitle(task.getTitle());
                    existing.setDescription(task.getDescription());
                    existing.setCompleted(task.isCompleted());
                    existing.setUpdatedAt(LocalDateTime.now());
                    return taskRepo.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Task not found with id " + id));
    }

    // Delete a task by ID
    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }
}
