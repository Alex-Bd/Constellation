package db.constellation.neo.music;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


@Configuration
public class MusicRouter {


    @Bean
    public RouterFunction<ServerResponse> musicListRoute(MusicHandler musicHandler) {
        return RouterFunctions
                .route(RequestPredicates
                .GET("/getmusic")
                .and(RequestPredicates
                .accept(MediaType.APPLICATION_JSON)), musicHandler::getArtists);
    }
    @Bean
    public RouterFunction<ServerResponse> songRoute(MusicHandler musicHandler) {
        return RouterFunctions
                .route(RequestPredicates
                .GET("/getsong/{artist}/{album}/{song}")
                .and(RequestPredicates
                .accept(MediaType.ALL)), musicHandler::getSong);
    }






}
