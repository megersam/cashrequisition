package awashproject.awwashproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("awashproject.awwashproject")
@ComponentScan("awashproject.awwashproject")
public class AwwashProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwwashProjectApplication.class, args);
        System.out.println("Awash project is working");
        System.out.println("Jwt added");
        System.out.println("JPA Added");
    }

}
