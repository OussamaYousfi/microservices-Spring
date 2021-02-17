package org.sid.demo;

import org.sid.entities.Product;
import org.sid.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("org.sid.repositories")
@EntityScan("org.sid.entities")
@EnableJpaRepositories("org.sid.repositories")
public class Demo1Application {

	@Autowired
	ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@Bean
	CommandLineRunner start() {
		return args -> {
			repository.save(new Product(null,"HP 878",1100));
			repository.save(new Product(null,"Mac Booc Pro",5200));
			repository.save(new Product(null,"Epson 32",250));
			repository.findAll().forEach(System.out::println);
		};
	}
}
