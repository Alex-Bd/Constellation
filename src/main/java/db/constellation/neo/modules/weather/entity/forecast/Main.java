package db.constellation.neo.modules.weather.entity.forecast;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
class Main {

    double temp;
    double temp_min;
    double temp_max;
    double humidity;

}
