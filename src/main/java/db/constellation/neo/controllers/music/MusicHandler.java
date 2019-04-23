package db.constellation.neo.controllers.music;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Component
@CrossOrigin
class MusicHandler {

    private WebClient client = WebClient.create("http://35.204.97.47:8081/music");

    Mono<ServerResponse> PreFlight(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Request-Method", "*").body(BodyInserters.empty());
    }
    Mono<ServerResponse> getMusic(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .header("Access-Control-Allow-Origin", "*")
                .body(BodyInserters
                        .fromPublisher(client.get().uri("/getMusic").retrieve().bodyToMono(String.class), String.class));
    }

    Mono<ServerResponse> getArtist(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .header("Access-Control-Allow-Origin", "*")
                .body(BodyInserters
                        .fromPublisher(client.get().uri("/getArtist/" + request.pathVariable("artist")).retrieve().bodyToMono(String.class), String.class));
    }

    Mono<ServerResponse> getAlbum(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .header("Access-Control-Allow-Origin", "*")
                .body(BodyInserters
                        .fromPublisher(client.get().uri("/getAlbum/" + request.pathVariable("artist") + "/" + request.pathVariable("album")).retrieve().bodyToMono(String.class), String.class));
    }

    Mono<ServerResponse> getSong(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .header("Access-Control-Allow-Origin", "*")
                .body(BodyInserters
                        .fromPublisher(client.get().uri("/getSong/" + request.pathVariable("artist") + "/" + request.pathVariable("album") + "/" + request.pathVariable("song")).retrieve().bodyToMono(String.class), String.class));
    }

    Mono<ServerResponse> checkArtist(ServerRequest request) {
        return ServerResponse.ok().header("Access-Control-Allow-Origin", "*").body(
                BodyInserters.fromPublisher(
                        client.get().uri("/checkArtist/" + request.pathVariable("artist")).retrieve().bodyToMono(Boolean.class), Boolean.class));
    }

    Mono<ServerResponse> addArtist(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .header("Access-Control-Allow-Origin", "*")
                .body(BodyInserters
                        .fromPublisher(client.post().uri("/addArtist/" + request.pathVariable("id") + "/" + request.pathVariable("artist")).retrieve().bodyToMono(String.class), String.class));
    }

    Mono<ServerResponse> changeArtistName(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .header("Access-Control-Allow-Origin", "*")
                .body(BodyInserters
                        .fromPublisher(client.patch().uri("/changeArtistName/" + request.pathVariable("id") + "/" + request.pathVariable("name")).retrieve().bodyToMono(String.class), String.class));
    }




    Mono<ServerResponse> checkAlbum(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .header("Access-Control-Allow-Origin", "*")
                .body(BodyInserters
                        .fromPublisher(client.get().uri("/checkAlbum/" + request.pathVariable("artist") + "/" + request.pathVariable("album")).retrieve().bodyToMono(String.class), String.class));
    }

    Mono<ServerResponse> addAlbum(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .header("Access-Control-Allow-Origin", "*")
                .body(BodyInserters
                        .fromPublisher(client.post().uri("/addAlbum/" + request.pathVariable("artist") + "/" + request.pathVariable("id") + "/" + request.pathVariable("album")).retrieve().bodyToMono(String.class), String.class));
    }

    Mono<ServerResponse> checkSong(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .header("Access-Control-Allow-Origin", "*")
                .body(BodyInserters
                        .fromPublisher(client.get().uri("/checkSong/" + request.pathVariable("artist") + "/" + request.pathVariable("album") + "/" + request.pathVariable("song")).retrieve().bodyToMono(String.class), String.class));
    }

    Mono<ServerResponse> addSong(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .header("Access-Control-Allow-Origin", "*")
                .body(BodyInserters
                        .fromPublisher(client.post().uri("/addSong/" + request.pathVariable("artist") + "/" + request.pathVariable("album") + "/" + request.pathVariable("id") + "/" + request.pathVariable("song")).retrieve().bodyToMono(String.class), String.class));
    }


}
