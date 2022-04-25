package mk.ukim.finki.lab2_emt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab2EmtApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab2EmtApplication.class, args);
    }

//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(10);
//    }

}
