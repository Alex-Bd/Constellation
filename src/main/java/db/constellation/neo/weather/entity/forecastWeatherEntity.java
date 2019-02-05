package db.constellation.neo.weather.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import db.constellation.neo.weather.entity.forecast.City;
import db.constellation.neo.weather.entity.forecast.Weather;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class forecastWeatherEntity {

    String cod;
    double message;
    int cnt;
    List<Weather> list;

}
