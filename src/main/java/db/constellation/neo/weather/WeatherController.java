package db.constellation.neo.weather;


import db.constellation.neo.weather.entity.currentWeatherEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


public class WeatherController {

    @Autowired
    WeatherApi api;


    @GetMapping("/getCurrent")
    public currentWeatherEntity currentWeather(
       @RequestParam(value="api", defaultValue="") int call
        ){
        System.out.println(call);
    return api.getWeather(call);
    }

    @GetMapping("/getForecast")
    public void forecast(){

    }
}
