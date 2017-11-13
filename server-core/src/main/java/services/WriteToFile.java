package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import jnksh.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class WriteToFile {
    private static final Logger log = LoggerFactory.getLogger(WriteToFile.class);
    protected File file;

    @Autowired
    public WriteToFile (@Value("server-core/src/main/resources/gps.txt")String path) {
        this.file = new File(path);

    }
     public boolean write(String coordinates) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        PointDTO pointDTO = mapper.readValue(coordinates, PointDTO.class);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.append(pointDTO.toString());
            fileWriter.append("\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            fileWriter.close();
            log.info("Координата записана " + pointDTO.toString());
        }
        return true;
    }
}