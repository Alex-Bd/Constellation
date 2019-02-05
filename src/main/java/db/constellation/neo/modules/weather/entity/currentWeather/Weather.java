package db.constellation.neo.modules.weather.entity.currentWeather;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    private int id;
    private String main;
    private String description;
    private String icon;


}
