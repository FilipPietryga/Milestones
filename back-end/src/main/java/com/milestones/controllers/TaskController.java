package com.milestones.controllers;

import com.milestones.models.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @GetMapping
    public List<Task> getTasks() {
        return Arrays.asList(
                new Task(1, "Task 1", "Description for Task 1", "To Do"),
                new Task(2, "Task 2", "Description for Task 2", "In Progress"),
                new Task(3, "Task 3", "Description for Task 3", "Done")
        );
    }
}
