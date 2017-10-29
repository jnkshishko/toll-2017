package services;

import jnksh.PointDTO;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;
import java.nio.file.Files;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

//@RunWith(MockitoJUnitRunner.class)
public class WriteToFileTest {
//    private static File dir;
//    @Mock
//    File file;
//
//    @InjectMocks
//    WriteToFile mockedWriteToFile;

    @Test
    public void write() throws Exception {
//        dir = Files.createTempDirectory(null).toFile();
//        when(file = new File("server-core/src/main/resources/gps.txt")).thenReturn(dir);
//        PointDTO pointDTO = new PointDTO();
//        pointDTO.setLat(135.2);
//        pointDTO.setLon(133.3);
//
//        mockedWriteToFile.write(pointDTO.toJson());
        PointDTO pointDTO = new PointDTO();
        pointDTO.setLat(135.1);
        pointDTO.setLon(111.1);

        WriteToFile writeToFile = new WriteToFile();
        Boolean result = writeToFile.write(pointDTO.toJson());
        assertEquals(true, result);


    }

}