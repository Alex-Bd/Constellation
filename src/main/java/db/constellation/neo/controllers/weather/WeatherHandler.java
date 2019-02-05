package db.constellation.neo.controllers.weather;

import db.constellation.neo.modules.weather.WeatherApi;
import db.constellation.neo.modules.weather.entity.CurrentWeatherEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class WeatherHandler {

    @Autowired
    WeatherApi api;
    public Mono<ServerResponse> getWeather(ServerRequest request){

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(
                      api.getWeather(api.cityFinder(request.queryParam("city").get()))
                        ));
    }
}
