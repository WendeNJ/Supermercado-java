package Supermercado.Program;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
=======
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4

@SpringBootApplication
public class ProgramApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgramApplication.class, args);
	}
<<<<<<< HEAD
	 {
			String hash = "$2a$12$YDxwzYIlU2sFcfGQmAdSk.0NBd12ec/zSVprQ4TaaWjqiq5f3bHhO";
			System.out.println(new BCryptPasswordEncoder().matches("123456", hash));
		}
	}


=======

}
>>>>>>> 9018151b395052bcf4fd0381c3acf2d5ac2647b4
