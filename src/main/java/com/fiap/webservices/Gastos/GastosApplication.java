package com.fiap.webservices.Gastos;

import com.fiap.webservices.Gastos.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class GastosApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(GastosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.userRepository.findAll().forEach(user -> {
			System.out.println(user.toString());
		});
	}
}
