package br.newtonpaiva.av2Security.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;



@SpringBootApplication(scanBasePackages = {"br.newtonpaiva"})
@EnableMongoRepositories("br.newtonpaiva.av2Security.Repository")
public class Av2SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(Av2SecurityApplication.class, args);
	}

}
