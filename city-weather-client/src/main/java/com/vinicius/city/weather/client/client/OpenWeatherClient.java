package com.vinicius.city.weather.client.client;

import com.vinicius.city.weather.client.client.response.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "weather", url = "${client.weather.baseUrl}")
public interface OpenWeatherClient {

    @GetMapping
    WeatherResponse findWeatherByCity(@RequestParam(name = "q") String city);

}
