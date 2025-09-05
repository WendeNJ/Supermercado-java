package Supermercado.Program;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ProgramApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgramApplication.class, args);
	}
	 {
			String hash = "$2a$12$YDxwzYIlU2sFcfGQmAdSk.0NBd12ec/zSVprQ4TaaWjqiq5f3bHhO";
			System.out.println(new BCryptPasswordEncoder().matches("123456", hash));
		}
	}


