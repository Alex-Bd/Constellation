package db.constellation.neo.music;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.*;

@Service
public class MusicController {

    RestTemplate rest = new RestTemplate();


    /*
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/getList")
    public String getMusicList(){
        return files.getList();
    }*/



   /* @GetMapping(value="/gets",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody byte[] getFile() throws IOException{
        File file = new File("D:\\Music\\SOiL\\Scars\\12 Why.mp3");
        InputStream in = getClass()
                .getResourceAsStream("D:\\Music\\SOiL\\Scars\\12 Why.mp3");
        return IOUtils.toByteArray(in);
    }*/



}
