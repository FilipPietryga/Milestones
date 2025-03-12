package com.milestones.controllers;

import com.milestones.models.TaskModel;
import com.milestones.services.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Tasks", description = "Task management API")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Get all tasks", description = "Retrieve a list of all tasks.")
    @GetMapping
    public List<TaskModel> getTasks() {
        return taskService.getAllTasks();
    }

    @Operation(summary = "Get a task by ID", description = "Retrieve a single task by its ID.")
    @GetMapping("/{id}")
    public Optional<TaskModel> getTask(
            @Parameter(description = "ID of the task to retrieve") @PathVariable long id) {
        return taskService.getTaskById(id);
    }

    @Operation(summary = "Create a new task", description = "Add a new task to the database.")
    @PostMapping
    public TaskModel createTask(
            @Parameter(description = "Task object to be created") @RequestBody TaskModel task) {
        return taskService.saveTask(task);
    }

    @Operation(summary = "Update a task", description = "Update an existing task's details.")
    @PutMapping("/{id}")
    public TaskModel updateTask(
            @Parameter(description = "ID of the task to update") @PathVariable long id,
            @Parameter(description = "Updated task object") @RequestBody TaskModel task) {
        Optional<TaskModel> existingTask = taskService.getTaskById(id);
        if (existingTask.isPresent()) {
            TaskModel updatedTask = existingTask.get();
            updatedTask.setStatus(task.getStatus());
            return taskService.saveTask(updatedTask);
        }
        return null;
    }

    @Operation(summary = "Delete a task", description = "Remove a task from the database by ID.")
    @DeleteMapping("/{id}")
    public void deleteTask(
            @Parameter(description = "ID of the task to delete") @PathVariable long id) {
        taskService.deleteTask(id);
    }
}
