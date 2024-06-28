package lt.lukas.weatherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherapiApplication {

    public static void main(String[] args) {
        System.out.println("http://localhost:8080/weather?city=vilnius");
        System.out.println("http://localhost:8080/allcities");
        SpringApplication.run(WeatherapiApplication.class, args);
    }

}
