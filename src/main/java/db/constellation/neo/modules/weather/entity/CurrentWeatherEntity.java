package db.constellation.neo.modules.weather.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import db.constellation.neo.modules.weather.entity.currentWeather.Main;
import db.constellation.neo.modules.weather.entity.currentWeather.Sys;
import db.constellation.neo.modules.weather.entity.currentWeather.Weather;
import db.constellation.neo.modules.weather.entity.currentWeather.Wind;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CurrentWeatherEntity {

    private List<Weather> weather;
    private Main main;
    private Wind wind;
    private Sys sys;
    private int id;
    private String name;

}
