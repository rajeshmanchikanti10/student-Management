package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Override
	public void run(String[] args){
		try{

		}
		catch (Exception e) {
			// Handle the exception or log it
			e.printStackTrace();
		}
	}
	@GetMapping("/hello")
	public List<String> hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return List.of("Hello", "World");
	}



}
