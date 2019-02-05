package db.constellation.neo.weather.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import db.constellation.neo.weather.entity.currentWeather.Main;
import db.constellation.neo.weather.entity.currentWeather.Sys;
import db.constellation.neo.weather.entity.currentWeather.Weather;
import db.constellation.neo.weather.entity.currentWeather.Wind;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class currentWeatherEntity {

    private List<Weather> weather;
    private Main main;
    private Wind wind;
    private Sys sys;
    private int id;
    private String name;

}
