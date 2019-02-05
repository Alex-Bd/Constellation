package db.constellation.neo.modules.weather;

import db.constellation.neo.modules.weather.cities.CityFinderService;

import db.constellation.neo.modules.weather.entity.CurrentWeatherEntity;
import db.constellation.neo.modules.weather.entity.ForecastWeatherEntity;
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

    public CurrentWeatherEntity getWeather(int location){
       CurrentWeatherEntity weather = restTemplate.getForObject(call.getCurrentWeatherCall(location), CurrentWeatherEntity.class);
       return weather;
    }

    public int cityFinder(String cityName) {
        return cityService.findByCity(cityName);
    }

    public ForecastWeatherEntity getForecast(int location){
        ForecastWeatherEntity forecast = restTemplate.getForObject(call.getDayForecast(location), ForecastWeatherEntity.class);
        return forecast;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
