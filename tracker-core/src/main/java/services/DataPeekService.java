package services;

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

    private BlockingDeque<PointDTO> queue =  new LinkedBlockingDeque<>(100);
    private int putCount;
    private int takeCount;

    final ArrayList<PointDTO> coordinatesForSend = new ArrayList<>();


    @Scheduled (cron = "${cron.prop.put}")
    void put() throws InterruptedException {
        int i = putCount++;
        log.info("DataPeekService.put " + i);

        queue.put(gpsService.recordedCoordinates.get(i));
    }
    @Scheduled (cron = "${cron.prop.take}")
    void take() throws InterruptedException {
        int i = takeCount++;
        log.info("DataPeekService.take " + i);
        coordinatesForSend.add(queue.take());
    }

}
