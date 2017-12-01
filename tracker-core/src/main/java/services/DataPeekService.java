package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import dao.repo.PointDTORepository;
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

//    @Autowired
//    public PointDTORepository pointDTORepository;

    @Autowired
    public PointDTOCRUD crud;

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
        PointDTO point = crud.create(gpsService.recordedCoordinates.get(i));

    }

    PointDTO take() throws JsonProcessingException, InterruptedException {
        int i = takeCount++;
        log.info("DataPeekService.take " + i);
        PointDTO point = new PointDTO();
        return point = crud.read(i);
    }

//    private void delete(PointDTO point) {
//        pointDTORepository.delete(point);
//    }
//
//    private void update(PointDTO point, double lat, double lon, String autoID) {
//        point.setLat(lat);
//        point.setLon(lon);
//        point.setAutoId(autoID);
//        pointDTORepository.save(point);
//    }
//
//    private PointDTO read(int id) {
//        return pointDTORepository.findOne(id);
//
//    }
//
//    private PointDTO create(PointDTO point) {
//        PointDTO pointset = new PointDTO();
//        pointset.setLat(point.getLat());
//        pointset.setLon(point.getLon());
//        pointset.setAutoId(point.getAutoId());
//        return pointDTORepository.save(pointset);
//    }
}
