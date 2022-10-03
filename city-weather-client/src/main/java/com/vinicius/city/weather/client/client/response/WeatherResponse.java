package com.vinicius.city.weather.client.client.response;


import com.vinicius.city.weather.client.client.model.Clouds;
import com.vinicius.city.weather.client.client.model.Coord;
import com.vinicius.city.weather.client.client.model.Main;
import com.vinicius.city.weather.client.client.model.Sys;
import com.vinicius.city.weather.client.client.model.Weather;
import com.vinicius.city.weather.client.client.model.Wind;

import java.util.List;

public record WeatherResponse(
        List<Weather> weather,
        Coord coord,
        String base,
        Main main,
        Long visibility,
        Wind wind,
        Clouds clouds,
        Long dt,
        Sys sys,
        Integer timezone,
        Long id,
        String name,
        Long cod
) {
}
