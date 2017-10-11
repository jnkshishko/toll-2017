package jnksh.services;

import de.micromata.opengis.kml.v_2_2_0.*;
import jnksh.PointDTO;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class GPSService {

    private ArrayList<Coordinate> coordinateList;
    private int countRecord;
    private int size;
    private PointDTO record = new PointDTO();
    public ArrayList<PointDTO> recordedCoordinates = new ArrayList<>();

    public ArrayList<Coordinate> getGPS() {

        ArrayList<Coordinate> coordinateList = new ArrayList<Coordinate>();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("17741.kml").getFile());

        final Kml kml = Kml.unmarshal(file);
        final Folder folder = (Folder) kml.getFeature();
        List<Feature> featureList = folder.getFeature();
        Placemark placemark;

        for (Feature f : featureList) {

            if (f instanceof Placemark) {
                placemark = (Placemark) f;
                LineString lineString = (LineString) placemark.getGeometry();
                List<Coordinate> coordinates = lineString.getCoordinates();
                coordinateList.addAll(coordinates);
            }

        }

        return coordinateList;
    }
    @PostConstruct
    public void init() {
        coordinateList = getGPS();
        size = coordinateList.size();
    }

    @Scheduled (cron = "${cron.prop.record}")
    private void track() {

        int count = countRecord++;
        double currentLat;
        double currentLon;

        if (size > count) {
            Coordinate coordinate = coordinateList.get(count);
            currentLat = coordinate.getLatitude();
            currentLon = coordinate.getLongitude();
            record.setLat(currentLat);
            record.setLon(currentLon);
            recordedCoordinates.add(record);

        }

    }




}
