package db.constellation.neo.controllers.weather;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class WeatherRouter {

    @Bean
    public RouterFunction<ServerResponse> currentWeatherRoute(WeatherHandler weatherHandler) {
        return RouterFunctions
                .route(RequestPredicates
                        .GET("/getWeather")
                        .and(RequestPredicates
                                .accept(MediaType.APPLICATION_JSON)), weatherHandler::getWeather);
    }
}
