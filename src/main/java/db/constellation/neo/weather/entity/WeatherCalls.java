package db.constellation.neo.weather.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WeatherCalls {

    private String serverName="http://api.openweathermap.org/data/2.5";
    @Value("${weather.appid}")
    private String apiid;
    private String api = "&appid=";
    private String metric = "&units=metric";
    private String currentWeather = "/currentWeather?id=";
    private String forecast = "/forecast?id=";

    public String getCurrentWeatherCall(int location){
        return serverName+currentWeather+location+metric+api+apiid;
    }

    public String getDayForecast(int location){
        return serverName+forecast+location+metric+api+apiid;
    }

}
