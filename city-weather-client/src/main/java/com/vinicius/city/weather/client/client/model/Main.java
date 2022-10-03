package com.vinicius.city.weather.client.client.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Main(
        Double temp,
        @JsonAlias("feels_like")
        Double feelsLike,
        @JsonAlias("temp_min")
        Double tempMin,
        @JsonAlias("temp_max")
        Double tempMax,
        Long pressure,
        Integer humidity
) {
}
