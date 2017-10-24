package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;

@Service
public class DataSendService {

    @Autowired
    public DataPeekService peekService;

    @Autowired
    public RestTemplate restTemplate;

    private static final Logger log = LoggerFactory.getLogger(DataSendService.class);
    final LinkedList<String> coordinateSend = new LinkedList<>();
    int sendCounter;
    String response;
    @Scheduled (cron = "${cron.prop.send}")
    void send() throws JsonProcessingException {

        try {
            peekService.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = sendCounter++;
        String a = coordinateSend.get(i);
        response = restTemplate.postForObject("http://localhost:8080/coordinates", a, String.class);
        log.info(response);
    }

}
