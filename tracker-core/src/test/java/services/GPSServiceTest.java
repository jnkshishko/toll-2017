package services;

import de.micromata.opengis.kml.v_2_2_0.Coordinate;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GPSServiceTest {
    @Test
    public void getGPS() throws Exception {

        GPSService gpsService = new GPSService();
        ArrayList<Coordinate> coordinates = gpsService.getGPS();
        assertNotNull(coordinates);

    }


}