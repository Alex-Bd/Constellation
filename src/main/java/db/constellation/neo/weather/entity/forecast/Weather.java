package db.constellation.neo.weather.entity.forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Weather {

    private String dt;
    private Main main;


}
