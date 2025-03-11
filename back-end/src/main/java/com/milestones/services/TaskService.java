package com.milestones.services;

import com.milestones.models.TaskModel;
import com.milestones.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskModel> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<TaskModel> getTaskById(long id) {
        return taskRepository.findById(id);
    }

    public TaskModel saveTask(TaskModel task) {
        return taskRepository.save(task);
    }

    public TaskModel updateTask(TaskModel task) {
        return taskRepository.save(task);
    }

    public void deleteTask(long id) {
        taskRepository.deleteById(id);
    }
}
