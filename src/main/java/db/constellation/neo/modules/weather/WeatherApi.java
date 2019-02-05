package db.constellation.neo.modules.weather;

import db.constellation.neo.modules.weather.cities.CityFinderService;

import db.constellation.neo.modules.weather.entity.CurrentWeatherEntity;
import db.constellation.neo.modules.weather.entity.ForecastWeatherEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherApi{

   private RestTemplate restTemplate  = new RestTemplate();


   private WeatherCalls call;
   private CityFinderService cityService;

   @Autowired
   public WeatherApi(WeatherCalls call,
                     CityFinderService cityService){
    this.call=call;
    this.cityService=cityService;
}

    public CurrentWeatherEntity getWeather(int location){
       return restTemplate.getForObject(call.getCurrentWeatherCall(location), CurrentWeatherEntity.class);
    }

    public int cityFinder(String cityName) {
        return cityService.findByCity(cityName);
    }

    public ForecastWeatherEntity getForecast(int location){
        return restTemplate.getForObject(call.getDayForecast(location), ForecastWeatherEntity.class);
    }

}
