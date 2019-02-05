package db.constellation.neo.weather.cities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityFinderService implements InitializingBean {

    ObjectMapper objectMapper = new ObjectMapper();
    ArrayList<CityEntity> cities = new ArrayList<CityEntity>();
    @Value("classpath:city.list.min.json")
    Resource file;

    @Override
    public void afterPropertiesSet() throws Exception {
        cities = objectMapper.readValue(file.getFile(), new TypeReference<List<CityEntity>>(){});
    }

    public int findByCity(String cityName) {
        CityEntity found = new CityEntity();

        for (CityEntity city : cities) {
            if (city.getName().compareTo(cityName) == 0) {
                found = city;
                break;
            }
        }
        return found.getId();
    }
}