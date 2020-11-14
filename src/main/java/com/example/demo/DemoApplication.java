package com.example.demo;

import com.example.demo.database.entity.User;
import com.example.demo.database.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo (UserRepository repository) {
		User user = new User();

		user.setId(5L);
		user.setFirstName("userFirstName");
		user.setLastName("userLastName");
		user.setAge(15);
		user.setEmail("userEmail@jdbc.com");

		//SAVE
		repository.save(user);

		//UPDATE
		user.setEmail("updatedUserEmail@jdbc.com");
		repository.update(user);

		//DELETE
		repository.delete(5L);

		//FIND BY EMAIL
		return (args) -> repository.findByEmail("updatedUserEmail@jdbc.com").ifPresent(System.out::println);
	}
}
