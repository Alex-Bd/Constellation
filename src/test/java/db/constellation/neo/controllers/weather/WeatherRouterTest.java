package db.constellation.neo.controllers.weather;

import db.constellation.neo.modules.weather.entity.CurrentWeatherEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherRouterTest {

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void currentWeatherRouteTest(){
        assertThat(restTemplate
                .getForEntity("http://localhost:8070/getWeather?city=Debrecen", CurrentWeatherEntity.class)
                .getBody().getName().compareTo("Debrecen") == 0);
    }

}
