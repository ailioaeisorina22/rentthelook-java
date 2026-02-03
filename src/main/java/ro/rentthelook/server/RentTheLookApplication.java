package ro.rentthelook.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RentTheLookApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentTheLookApplication.class, args);
		System.out.println("=== RENTTHELOOK SERVER STARTED ===");
	}

}
