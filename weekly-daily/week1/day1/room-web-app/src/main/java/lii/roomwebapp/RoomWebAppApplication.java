package lii.roomwebapp;

import lii.roomwebapp.data.repository.RoomRepository;
import lii.roomwebapp.data.repository.StaffRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RoomWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomWebAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(RoomRepository roomRepository, StaffRepository staffRepository) {
		return args -> {
			System.out.println("_----Rooms___--");
			roomRepository.findAll().forEach(System.out::println);
			System.out.println("\n\n-====== Employees ====-");
			staffRepository.findAll().forEach(System.out::println);
		};
	}
}
