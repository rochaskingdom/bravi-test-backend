package com.vinicius.city.weather.client.controller;

import com.vinicius.city.weather.client.client.OpenWeatherClient;
import com.vinicius.city.weather.client.client.response.WeatherResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class WeatherController {

    private final OpenWeatherClient client;

    @GetMapping
    public WeatherResponse findWeatherByCity(@RequestParam(name = "city") String city) {
        log.info("Iniciando busca de condição climática da cidade - [{}]", city);
        var weather = client.findWeatherByCity(city);
        log.info("Condição climática encontrada com sucesso - [{}]", weather);
        return weather;
    }
}
