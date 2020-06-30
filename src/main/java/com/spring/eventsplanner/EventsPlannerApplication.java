package com.spring.eventsplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// scaneaza proiectul si identifica clasele: Controllers, Services, Config, Modele...
// autoconfigureaza proiectul 
@SpringBootApplication
public class EventsPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsPlannerApplication.class, args);
	}

}
