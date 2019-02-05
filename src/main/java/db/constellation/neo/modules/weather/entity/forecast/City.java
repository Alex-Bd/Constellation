package db.constellation.neo.modules.weather.entity.forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class City {

    String id;
    String name;
    String country;
}
