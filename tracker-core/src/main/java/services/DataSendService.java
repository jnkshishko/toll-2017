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

    private final RestTemplate restTemplate;
    private final DataPeekService peekService;

    public DataSendService(@Autowired RestTemplate restTemplate, @Autowired DataPeekService peekService) {
        this.restTemplate = restTemplate;
        this.peekService = peekService;
    }

    private static final Logger log = LoggerFactory.getLogger(DataSendService.class);

    String response;

    String nextCoord;

    @Scheduled (cron = "${cron.prop.send}")
    String send() throws InterruptedException, JsonProcessingException {

        nextCoord = peekService.take();
        response = restTemplate.postForObject("http://localhost:8080/coordinates", nextCoord, String.class);
        log.info(response);
        return response;
    }

}
