package jnksh.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import jnksh.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DataSendService {

    @Autowired
    private DataPeekService peekService;

    private static final Logger log = LoggerFactory.getLogger(DataSendService.class);
    final ArrayList<String> coordinateSend = new ArrayList<>();

    void send() throws JsonProcessingException{

        for (String a : coordinateSend) {
            log.info(a);
        }

    }

}
