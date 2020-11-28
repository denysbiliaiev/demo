package com.example.demo;

import com.example.demo.database.entity.Gender;
import com.example.demo.database.entity.UserEntity;
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
		UserEntity userEntity = new UserEntity();

		userEntity.setFirstName("userFirstName");
		userEntity.setLastName("userLastName");
		userEntity.setGender(Gender.MALE);
		userEntity.setAge(15);

		//SAVE
		repository.save(userEntity);

		//FIND BY ID
		return (args) -> repository.findById(5L).ifPresent(System.out::println);
	}
}
