package db.constellation.neo.controllers.music;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;

@Component
@CrossOrigin
public class MusicHandler {
   WebClient client = WebClient.create("http://localhost:8081");

    public Mono<ServerResponse> getAll(ServerRequest request){
        URI location = null;
        System.out.println("hello");
        try {
           location = new URI("http://www.tankcsapda.hu/files/userfiles/Image/2013/tankcsapda_vivacomet.jpg");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return ServerResponse.seeOther(location)
                .header("Access-Control-Allow-Origin","*").build();
    }

  public Mono<ServerResponse> getArtists(ServerRequest request){
      return ServerResponse.ok()
              .contentType(MediaType.APPLICATION_JSON)
              .header("Access-Control-Allow-Origin","*")
              .body(BodyInserters
              .fromPublisher( client.get().uri("/getmusic").retrieve().bodyToMono(String.class),
                      String.class));
  }

   public Mono<ServerResponse> getSong(ServerRequest request){
       WebClient client = WebClient.create("http://localhost:8081");

       client.get()
               .uri("getmusic/{artist}/{album}/{song}",request.pathVariables())
               .accept(MediaType.ALL)
               .retrieve()
               .bodyToMono(String.class)
               .subscribe(person -> System.out.println("GET: " + person));


      return ServerResponse.ok()
              .contentType(MediaType.APPLICATION_JSON)
              .header("Access-Control-Allow-Origin","*")
              .body(BodyInserters
              .fromPublisher(client.get().uri("getmusic/{artist}/{album}/{song}",request.pathVariables()).retrieve().bodyToMono(String.class),
                      String.class));
  }


}
