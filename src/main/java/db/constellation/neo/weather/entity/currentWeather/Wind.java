package db.constellation.neo.weather.entity.currentWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {

    private float speed;
    private int degree;

}
