package db.constellation.neo.weather;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherApiTest {

    @Autowired
    WeatherApi api;

    @Test
    public void getWeather(String location){

    }

    @Test
    public void cityFinder(String cityName){
        api.cityFinder("Nyi");
    }

}
