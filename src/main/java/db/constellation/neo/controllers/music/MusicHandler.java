package db.constellation.neo.controllers.music;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;

@Component
@CrossOrigin
class MusicHandler {

    private URI location;

    Mono<ServerResponse> getArtists(ServerRequest request) {
        try {
            location = new URI("http://localhost:8081/music/getMusic");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return ServerResponse
                .permanentRedirect(location)
                .build();
    }

    Mono<ServerResponse> getSong(ServerRequest request) {
        try {
            location = new URI(("http://localhost:8081/music/getSong/"
                    + request.pathVariable("artist") + "/"
                    + request.pathVariable("album") + "/"
                    + request.pathVariable("song")).replaceAll(" ", "%20"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return ServerResponse
                .permanentRedirect(location)
                .build();
    }

    Mono<ServerResponse> addSong(ServerRequest request) {
        try {
            location = new URI(("http://localhost:8081/music/addSong/"
                    + request.pathVariable("artist") + "/"
                    + request.pathVariable("album") + "/"
                    + request.pathVariable("song")).replaceAll(" ", "%20"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return ServerResponse
                .permanentRedirect(location)
                .build();
    }

}
