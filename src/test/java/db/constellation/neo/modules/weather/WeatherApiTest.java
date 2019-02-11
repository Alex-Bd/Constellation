package db.constellation.neo.modules.weather;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherApiTest {

    @Autowired
    WeatherApi api;

    @Test
    public void cityFinderTest(){
        assertEquals(716935,api.cityFinder("Nyiregyhaza"));
    }

    @Test
    public void getCurrentWeatherTest(){
        assertEquals("Nyiregyhaza" ,api.getWeather(api.cityFinder("Nyiregyhaza")).getName());
    }

    @Test
    public void getForecastTest(){
        assertEquals("Nyiregyhaza" ,api.getForecast(api.cityFinder("Nyiregyhaza")).getCity().getName());
    }




}
