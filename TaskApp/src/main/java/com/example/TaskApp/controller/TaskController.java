package com.example.TaskApp.controller;

import com.example.TaskApp.aop.Auditable;
import com.example.TaskApp.model.Task;
import com.example.TaskApp.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        // cast to Auditable to set audit data
        Auditable auditable = (Auditable) taskService;
        auditable.setCreatedBy("Esraa (API User)");

        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> getAll() {
        return taskService.getAllTasks();
    }
}
