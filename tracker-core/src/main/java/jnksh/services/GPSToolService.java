package jnksh.services;

import de.micromata.opengis.kml.v_2_2_0.*;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class GPSToolService {



    public ArrayList<Coordinate> getGPS() {
        System.out.println("hi");
        ArrayList<Coordinate> coordinateList = new ArrayList<Coordinate>();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("17741.kml").getFile());

        final Kml kml = Kml.unmarshal(file);
        final Folder folder = (Folder) kml.getFeature();
        List<Feature> featureList = folder.getFeature();
        Placemark placemark = null;

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

}
