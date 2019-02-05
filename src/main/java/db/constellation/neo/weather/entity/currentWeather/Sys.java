package db.constellation.neo.weather.entity.currentWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sys {

    private int type;
    private int id;
    private float message;
    private String country;
    private int sunrise;
    private int sunset;


}
