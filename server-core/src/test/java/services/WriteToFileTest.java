package services;

import jnksh.PointDTO;
import org.junit.Test;
import static org.junit.Assert.*;


public class WriteToFileTest {

    @Test
    public void write() throws Exception {

        PointDTO pointDTO = new PointDTO();
        pointDTO.setLat(135.2);
        pointDTO.setLon(133.3);

        WriteToFile writeToFile = new WriteToFile();

        writeToFile.write(pointDTO.toJson());


    }

}