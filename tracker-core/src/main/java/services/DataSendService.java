package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class DataSendService {

    private static final Logger log = LoggerFactory.getLogger(DataSendService.class);

    private String response;

    private String nextCoord;

    private final RestTemplate restTemplate;
    private final DataPeekService peekService;

    public DataSendService(@Autowired RestTemplate restTemplate, @Autowired DataPeekService peekService) {
        this.restTemplate = restTemplate;
        this.peekService = peekService;
    }

    @Scheduled (cron = "${cron.prop.send}")
    String send() throws InterruptedException, JsonProcessingException {

        nextCoord = peekService.take().toJson();
        response = restTemplate.postForObject("http://localhost:8080/coordinates", nextCoord, String.class);
        log.info(response);
        return response;
    }

}
