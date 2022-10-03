package com.vinicius.city.weather.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CityWeatherClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CityWeatherClientApplication.class, args);
    }

}
