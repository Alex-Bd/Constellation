package db.constellation.neo.weather;

import db.constellation.neo.weather.cities.CityFinderService;
import db.constellation.neo.weather.entity.WeatherCalls;

import db.constellation.neo.weather.entity.currentWeatherEntity;
import db.constellation.neo.weather.entity.forecastWeatherEntity;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherApi implements InitializingBean {
   RestTemplate restTemplate  = new RestTemplate();

   @Autowired
   WeatherCalls call;
   @Autowired
   CityFinderService cityService;

    public currentWeatherEntity getWeather(int location){
       currentWeatherEntity weather = restTemplate.getForObject(call.getCurrentWeatherCall(location),currentWeatherEntity.class);
       return weather;
    }
    public int cityFinder(String cityName){
        return cityService.findByCity(cityName);
    }

    public forecastWeatherEntity getForecast(int location){
        forecastWeatherEntity forecast = restTemplate.getForObject(call.getDayForecast(location),forecastWeatherEntity.class);
        return forecast;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(getForecast(cityFinder("Nyiregyhaza")));
    }
}
