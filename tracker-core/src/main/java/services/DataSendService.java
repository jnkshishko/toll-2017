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
    int counter;
    int sendCounter;
    @Scheduled (cron = "${cron.prop.send}")
    void send() throws JsonProcessingException {

        int count = counter++;
        coordinateSend.add(peekService.coordinatesForSend.get(count).toJson());
        int i = sendCounter++;
        String a = coordinateSend.get(i);
        restTemplate.put("http://localhost:8080/coordinates", a);
        log.info(a);
//        for (String a : coordinateSend) {
//            log.info(a);
//            restTemplate.put("http://localhost:8080/coordinates", a);
//
//        }

    }

}
