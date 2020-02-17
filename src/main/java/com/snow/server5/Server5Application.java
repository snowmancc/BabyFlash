package com.snow.server5;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Server5Application {

    public static void main(String[] args) {
        SpringApplication.run(Server5Application.class, args);
    }

}
