package jnksh.services;

import de.micromata.opengis.kml.v_2_2_0.Coordinate;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Point;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class GPSToolService {

    public ArrayList<Coordinate> getGPS() {
        System.out.println("hi");
        ArrayList<Coordinate> coordinateList = new ArrayList<Coordinate>();

        final Kml kml = Kml.unmarshal(new File("17741.kml"));
        final Placemark placemark = (Placemark) kml.getFeature();
        Point point = (Point) placemark.getGeometry();
        List<Coordinate> coordinates = point.getCoordinates();
        coordinateList.addAll(coordinates);
        for (Coordinate coordinate : coordinates) {
            System.out.println(coordinate.getLatitude());
            System.out.println(coordinate.getLongitude());
            System.out.println(coordinate.getAltitude());

        }
        return coordinateList;
    }

    public void print() {
        System.out.println("hi");
    }
}
