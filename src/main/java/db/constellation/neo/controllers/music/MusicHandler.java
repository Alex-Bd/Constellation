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
   private WebClient client = WebClient.create("http://localhost:8081");

  Mono<ServerResponse> getArtists(ServerRequest request){
      return ServerResponse.ok()
              .contentType(MediaType.APPLICATION_JSON)
              .header("Access-Control-Allow-Origin","*")
              .body(BodyInserters
              .fromPublisher( client.get().uri("/getmusic").retrieve().bodyToMono(String.class),
                      String.class));
  }

   Mono<ServerResponse> getSong(ServerRequest request){

      return ServerResponse.ok()
              .contentType(MediaType.APPLICATION_JSON)
              .header("Access-Control-Allow-Origin","*")
              .body(BodyInserters
              .fromPublisher(client.get().uri("getmusic/{artist}/{album}/{song}",request.pathVariables()).retrieve().bodyToMono(String.class),
                      String.class));
  }


}
