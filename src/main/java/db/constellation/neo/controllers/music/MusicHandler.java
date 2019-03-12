package db.constellation.neo.controllers.music;

import org.apache.http.client.utils.URIBuilder;
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


    Mono<ServerResponse> getMusic(ServerRequest request) {
        try {
            location = new URI("http://localhost:8081/music/getMusic");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return ServerResponse
                .temporaryRedirect(location)
                .header("Access-Control-Allow-Origin","*").build();
    }

    Mono<ServerResponse> getArtist(ServerRequest request) {
        try {
            location = new URI(("http://localhost:8081/music/getArtist"
                    + request.pathVariable("artist")));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return ServerResponse
                .temporaryRedirect(location)
                .header("Access-Control-Allow-Origin","*")
                .build();
    }

    Mono<ServerResponse> getAlbum(ServerRequest request) {
        try {
            location = new URI(("http://localhost:8081/music/getAlbum"
                    + request.pathVariable("artist")+ "/"
                    + request.pathVariable("album")));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return ServerResponse
                .temporaryRedirect(location)
                .header("Access-Control-Allow-Origin","*")
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
                .temporaryRedirect(location)
                .header("Access-Control-Allow-Origin","*")
                .build();
    }

    Mono<ServerResponse> addArtist(ServerRequest request) {
        try {
            location = new URIBuilder()
                    .setScheme("http")
                    .setHost("localhost")
                    .setPort(8081)
                    .setPath("/music/addArtist/"+request.pathVariable("artist"))
                    .build();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return ServerResponse
                .temporaryRedirect(location)
                .header("Access-Control-Allow-Origin","*")
                .build();
    }
    Mono<ServerResponse> addAlbum(ServerRequest request) {
        try {
            location = new URIBuilder()
                    .setScheme("http")
                    .setHost("localhost")
                    .setPort(8081)
                    .setPath("/music/addAlbum/"+request.pathVariable("artist")+"/"+request.pathVariable("album"))
                    .build();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return ServerResponse
                .temporaryRedirect(location)
                .header("Access-Control-Allow-Origin","*")
                .build();
    }


//Not implemented..
    Mono<ServerResponse> addSong(ServerRequest request) {


        return ServerResponse.ok()
                .header("Access-Control-Allow-Origin", "*")
                .body(Mono.just("SUCCESS"), String.class);



/*
        try {
            location =new URI( "");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        MultipartBodyBuilder builder = new MultipartBodyBuilder();

        return request.body(BodyExtractors.toMultipartData()).flatMap(p -> {
            p.toSingleValueMap().keySet().stream().forEach(c -> {
                Part fp =  p.toSingleValueMap().get(c);
                   // File temp = File.createTempFile(fp.filename(),".mp3");
                   // fp.transferTo(temp);
                    builder.part(c, );
            });

            WebClient client = WebClient.create("");
            client.post()
                    .contentType(MediaType.MULTIPART_FORM_DATA)
                    .syncBody(builder.build())
                    .exchange()
                    .flatMap(res -> res.bodyToMono(String.class)).subscribe();

            return ServerResponse.ok()
                    .header("Access-Control-Allow-Origin", "*")
                    .body(Mono.just("SUCCESS"), String.class);
        });*/



}

}
