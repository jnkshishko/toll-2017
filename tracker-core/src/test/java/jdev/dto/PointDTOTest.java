package jdev.dto;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PointDTOTest {

    @Test
    public void toJson() throws Exception {
        PointDTO point = new PointDTO();
        point.setLat(40);
        point.setLon(30);
        point.setAutoId("a012bcd");

        assertTrue(point.toJson().contains("\"lat\":40"));
    }
}
