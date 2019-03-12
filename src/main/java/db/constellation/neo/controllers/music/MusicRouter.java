package db.constellation.neo.controllers.music;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


@Configuration
public class MusicRouter {

    @Bean
    public RouterFunction<ServerResponse> musicListRoute(MusicHandler musicHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/music/getMusic"), musicHandler::getMusic)
                .andRoute(RequestPredicates.GET("/music/getArtist/{artist}/{album}/{song}"),musicHandler::getArtist)
                .andRoute(RequestPredicates.GET("/music/getAlbum/{artist}/{album}/{song}"),musicHandler::getAlbum)
                .andRoute(RequestPredicates.GET("/music/getSong/{artist}/{album}/{song}"),musicHandler::getSong)

                .andRoute(RequestPredicates.POST("/music/addArtist/{artist}"),musicHandler::addArtist)
                .andRoute(RequestPredicates.POST("/music/addAlbum/{artist}/{album}"),musicHandler::addAlbum)
                .andRoute(RequestPredicates.POST("/music/addSong"), musicHandler::addSong)
                ;
    }

}
