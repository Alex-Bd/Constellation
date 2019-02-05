package db.constellation.neo.controllers.weather;

import db.constellation.neo.modules.weather.WeatherApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@CrossOrigin
@Component
public class WeatherHandler {

    private WeatherApi api;

    @Autowired
    public WeatherHandler( WeatherApi api) {
        this.api=api;
    }

    Mono<ServerResponse> getWeather(ServerRequest request){

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .header("Access-Control-Allow-Origin","*")
                .body(BodyInserters.fromObject(
                      api.getWeather(api.cityFinder(request.queryParam("city").get()))
                       ));
    }
    Mono<ServerResponse> getForecast(ServerRequest request){

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .header("Access-Control-Allow-Origin","*")
                .body(BodyInserters.fromObject(
                      api.getForecast(api.cityFinder(request.queryParam("city").get()))
                        ));
    }


}
