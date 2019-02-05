package db.constellation.neo.modules.weather.entity.currentWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {

    private float temp;
    private int pressure;
    private int humidity;
    private float temp_min;
    private float temp_max;

}
