package jnksh.services;

import jnksh.PointDTO;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;


@Service
public class DataPeekService {

    private static final Logger log = LoggerFactory.getLogger(DataPeekService.class);

    private BlockingDeque<PointDTO> queue =  new LinkedBlockingDeque<>(100);
    private int putCount;

    final ArrayList<PointDTO> coordinatesForSend = new ArrayList<>();


    void take() throws InterruptedException {
            coordinatesForSend.add(queue.takeLast());
        }

    void put(PointDTO a) throws InterruptedException {
        int i = putCount++;
        log.info("DataPeekService.put " + i);
        queue.put(a);
    }

}
