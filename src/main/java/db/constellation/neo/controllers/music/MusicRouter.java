package db.constellation.neo.controllers.music;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@CrossOrigin
@Configuration
public class MusicRouter {

    @Bean
    public RouterFunction<ServerResponse> musicListRoute(MusicHandler musicHandler) {
        return RouterFunctions
                .route(RequestPredicates.OPTIONS("/music/changeArtistName/{id}/{name}"),musicHandler::PreFlight)
                .andRoute(RequestPredicates.GET("/music/getMusic"), musicHandler::getMusic)
                .andRoute(RequestPredicates.GET("/music/getArtist/{artist}"),musicHandler::getArtist)
                .andRoute(RequestPredicates.GET("/music/getAlbum/{artist}/{album}"),musicHandler::getAlbum)
                .andRoute(RequestPredicates.GET("/music/getSong/{artist}/{album}/{song}"),musicHandler::getSong)


                .andRoute(RequestPredicates.GET("/music/checkArtist/{artist}"), musicHandler::checkArtist)
                .andRoute(RequestPredicates.POST("/music/addArtist/{id}/{artist}"),musicHandler::addArtist)
                .andRoute(RequestPredicates.PUT("/music/changeArtistName/{id}/{name}"),musicHandler::changeArtistName)



                .andRoute(RequestPredicates.GET("/music/checkAlbum/{artist}/{album}"), musicHandler::checkAlbum)
                .andRoute(RequestPredicates.POST("/music/addAlbum/{artist}/{id}/{album}"),musicHandler::addAlbum)

                .andRoute(RequestPredicates.GET("/music/checkSong/{artist}/{album}/{song}"), musicHandler::checkSong)
                .andRoute(RequestPredicates.POST("/music/addSong/{artist}/{album}/{id}/{song}"), musicHandler::addSong);
    }

}
