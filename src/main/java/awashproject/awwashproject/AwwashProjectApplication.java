package awashproject.awwashproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication

public class AwwashProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwwashProjectApplication.class, args);
        System.out.println("Awash project is working");
        System.out.println("Jwt added");
        System.out.println("JPA Added");
    }

}
