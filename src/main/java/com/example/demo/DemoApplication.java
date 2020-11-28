package com.example.demo;

import com.example.demo.database.entity.Gender;
import com.example.demo.database.entity.UserEntity;
import com.example.demo.database.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

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
		userEntity.setEmail("userLastName@springData.com");
		userEntity.setGender(Gender.MALE);
		userEntity.setAge(15);

		//SAVE
		repository.save(userEntity);

		//PAGINATION
		//repository.findAll(PageRequest.of(1, 10, Sort.Direction.DESC, "age"));

		//FIND BY ID
		return (args) -> repository.findById(5L).ifPresent(System.out::println);
	}
}
