package services;


import jnksh.PointDTO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WriteToFileTest {


    @Test
    public void write() throws Exception {

        String path = "src/main/resources/gps.txt";
        WriteToFile writeToFile = new WriteToFile(path);
        PointDTO pointDTO = new PointDTO();
        pointDTO.setLon(130.1);
        pointDTO.setLat(120.1);

        Boolean result = writeToFile.write(pointDTO.toJson());
        assertEquals(true, result);

    }

}