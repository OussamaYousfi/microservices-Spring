package org.sid.customerservice;

import org.sid.entities.Customer;
import org.sid.repositories.CustomerRepository;
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
public class CustomerServiceApplication {

	@Autowired
	CustomerRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	
@Bean
CommandLineRunner start() {
		return args -> {
			repository.save(new Customer(0,"ESPRT","Oussama@esprit.tn"));
			repository.save(new Customer(0,"ibm","ibm@esprit.tn"));
			repository.save(new Customer(0,"hp","hp@hp.nig"));
			repository.findAll().forEach(System.out::println);
		};
	}
} 
