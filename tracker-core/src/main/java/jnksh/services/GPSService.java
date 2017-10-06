package jnksh.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.micromata.opengis.kml.v_2_2_0.Coordinate;
import jnksh.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Service
public class GPSService {

    private ArrayList<Coordinate> coordinateList;
    private int count;
    private int size;
    private PointDTO record = new PointDTO();


    @Autowired
    private GPSToolService gpsToolService;

    @Autowired
    private DataPeekService peekService;

    @Autowired
    private DataSendService sendService;

    @PostConstruct
    public void init() {
        coordinateList = gpsToolService.getGPS();
        size = coordinateList.size();
    }

    @Scheduled (cron = "${cron.prop.put}")
    private void track() {

        double currentLat;
        double currentLon;
        double currentAlt;

        if (size > count) {
            Coordinate coordinate = coordinateList.get(count);
            currentLat = coordinate.getLatitude();
            currentLon = coordinate.getLongitude();
            currentAlt = coordinate.getAltitude();

            record.setLat(currentLat);
            record.setLon(currentLon);


            try {
                peekService.put(record);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                peekService.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                sendService.coordinateSend.add(peekService.coordinatesForSend.get(count).toJson());
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            count++;
        }

    }

    @Scheduled (cron = "${cron.prop.send}")
    private void send() {
//        System.out.println(peekService.coordinatesForSend);
        try {
            sendService.send();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


}
