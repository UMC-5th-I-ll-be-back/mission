package umc.springmission7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringMission7Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringMission7Application.class, args);
	}

}
