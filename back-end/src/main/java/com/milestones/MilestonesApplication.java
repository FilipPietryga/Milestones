package com.milestones;

import com.milestones.models.TaskModel;
import com.milestones.repositories.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MilestonesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MilestonesApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TaskRepository taskRepository) {
		return (args) -> {
			taskRepository.save(new TaskModel("Task 1", "Description for Task 1", "todo"));
			taskRepository.save(new TaskModel("Task 2", "Description for Task 2", "in_progress"));
			taskRepository.save(new TaskModel("Task 3", "Description for Task 3", "done"));
		};
	}
}
