package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import jnksh.PointDTO;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;


@Service
public class DataPeekService {

    @Autowired
    public GPSService gpsService;

    private static final Logger log = LoggerFactory.getLogger(DataPeekService.class);

    BlockingDeque<PointDTO> queue =  new LinkedBlockingDeque<>(100);
    private int putCount;
    private int takeCount;

    final ArrayList<PointDTO> coordinatesForSend = new ArrayList<>();


    @Scheduled (cron = "${cron.prop.put}")
    void put() throws InterruptedException {
        gpsService.track();
        int i = putCount++;
        log.info("DataPeekService.put " + i);

        queue.put(gpsService.recordedCoordinates.get(i));
    }

    String take() throws JsonProcessingException, InterruptedException {
        int i = takeCount++;
        log.info("DataPeekService.take " + i);
        return queue.take().toJson();
    }

}
