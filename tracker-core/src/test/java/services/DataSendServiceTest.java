package services;

import jnksh.PointDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;



import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)

public class DataSendServiceTest {

    @Mock
    RestTemplate restTemplate;

    @Mock
    DataPeekService peekService;

    @InjectMocks
    DataSendService mockedSendService;

    @Test
    public void send() throws Exception {
        DataPeekService peek = new DataPeekService();
        PointDTO pointDTO = new PointDTO();
        pointDTO.setLon(135.5);
        pointDTO.setLat(133.3);
        peek.queue.put(pointDTO);
        String a = peek.queue.take().toJson();
        when(peekService.take()).thenReturn(a);
        when(restTemplate.postForObject("http://localhost:8080/coordinates", a, String.class)).thenReturn("ok");
        String result = mockedSendService.send();
        assertEquals("ok", result);
    }

}