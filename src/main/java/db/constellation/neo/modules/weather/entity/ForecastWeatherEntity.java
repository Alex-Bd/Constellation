package db.constellation.neo.modules.weather.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import db.constellation.neo.modules.weather.entity.forecast.City;
import db.constellation.neo.modules.weather.entity.forecast.WeatherList;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastWeatherEntity {


    City City;
    List<WeatherList> list;

}
