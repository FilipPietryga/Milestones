package com.milestones;

import com.milestones.models.Task;
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
			taskRepository.save(new Task("Task 1", "Description for Task 1", "To Do"));
			taskRepository.save(new Task("Task 2", "Description for Task 2", "In Progress"));
			taskRepository.save(new Task("Task 3", "Description for Task 3", "Done"));
		};
	}
}
