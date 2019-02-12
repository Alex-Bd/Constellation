package db.constellation.neo.controllers.music;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicRouterTest {

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void getMusicTest(){
        assertEquals(HttpStatus.PERMANENT_REDIRECT
                    ,restTemplate
                        .getForEntity("http://localhost:8070/music/getMusic"
                                        ,String.class).getStatusCode());
    }

    @Test
    public void getSongTest(){
        assertEquals(HttpStatus.PERMANENT_REDIRECT
                    ,restTemplate
                        .getForEntity("http://localhost:8070/music/getSong/test/test/test"
                                        ,String.class).getStatusCode());
    }

    @Test
    public void addSongTest(){
        HttpEntity<String> request = new HttpEntity<>("bar");
        assertEquals(HttpStatus.PERMANENT_REDIRECT
                    ,restTemplate.postForEntity("http://localhost:8070/music/addSong/test/test/test",request,String.class).getStatusCode());

    }


}
