package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

	@Bean
	CommandLineRunner loadData(EmployeeRepository repository) {
		return args -> {
			repository.save(new Employee("Frodo Baggins", "ring bearer"));
			repository.save(new Employee("Bilbo Baggins", "burglar"));
			repository.save(new Employee("Samwise Gamgee", "gardener"));
			repository.save(new Employee("Merry Bandibuck", "firework lighter"));
			repository.save(new Employee("Gandalf the Grey", "wizard"));
		};
	}
}
