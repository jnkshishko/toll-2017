package jnksh;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PointDTOTest {

    private final String autoId = "a012bcd";

    @Test
    public void toJson() throws Exception {
        PointDTO point = new PointDTO();
        point.setLat(40);
        point.setLon(30);
        point.setAutoId(autoId);
        String s = point.toJson();
        assertTrue(s.contains("\"lat\":40"));
    }

    @Test
    public void fromJson() throws Exception {
        PointDTO point = new PointDTO();
        PointDTO point2 = new PointDTO();
        point.setLat(40);
        point.setLon(30);
        point.setAutoId(autoId);
        String a = point.toJson();
        point2 = point2.fromJson(a);
        assertTrue(point2.toJson().contains("\"lat\":40"));
    }
}
