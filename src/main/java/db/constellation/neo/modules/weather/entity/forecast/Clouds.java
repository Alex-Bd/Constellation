package db.constellation.neo.modules.weather.entity.forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Clouds {
    private int all;
}
