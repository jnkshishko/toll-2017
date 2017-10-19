package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DataSendService {

    @Autowired
    public DataPeekService peekService;

    private static final Logger log = LoggerFactory.getLogger(DataSendService.class);
    final ArrayList<String> coordinateSend = new ArrayList<>();

    @Scheduled (cron = "${cron.prop.send}")
    void send() throws JsonProcessingException{

        int count = 0;

        coordinateSend.add(peekService.coordinatesForSend.get(count++).toJson());
        for (String a : coordinateSend) {
            log.info(a);
        }

    }

}
