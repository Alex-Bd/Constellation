package db.constellation.neo.modules.weather.entity.forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class WeatherList {

    private String dt;
    private Main main;
    private List<Weather> weather;
    private Wind wind;
    private String dt_txt;
}
