// Main entry point for the OnboardEase Spring Boot application
// This class boots up the application context and starts the web server
package dev.nano.tptragbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
