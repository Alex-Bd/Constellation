package db.constellation.neo.controllers.weather;

import db.constellation.neo.modules.weather.entity.CurrentWeatherEntity;
import db.constellation.neo.modules.weather.entity.ForecastWeatherEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherRouterTest {

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void weatherRouteTest(){
        assertEquals("Debrecen",restTemplate
                .getForEntity("http://localhost:8070/Weather?city=Debrecen", CurrentWeatherEntity.class).getBody().getName()
                );
}
    @Test
    public void forecastRouteTest(){

        assertEquals("Debrecen",restTemplate.getForEntity("http://localhost:8070/Forecast?city=Debrecen", ForecastWeatherEntity.class)
                .getBody().getCity().getName());

    }

}
