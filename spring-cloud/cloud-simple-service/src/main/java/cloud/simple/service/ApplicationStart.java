package cloud.simple.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApplicationStart {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class, args);
    }
}
