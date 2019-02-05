package db.constellation.neo.weather.cities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CityEntity {

    private int id;
    private String name;
    private String country;


}
