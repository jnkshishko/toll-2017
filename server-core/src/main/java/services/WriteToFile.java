package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import jnksh.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class WriteToFile {
    private static final Logger log = LoggerFactory.getLogger(WriteToFile.class);

    public void write(String coordinates) throws IOException {
        File file = new File("gps.txt");
        ObjectMapper mapper = new ObjectMapper();
        PointDTO pointDTO = mapper.readValue(coordinates, PointDTO.class);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(pointDTO.toString());
            bufferedWriter.write("\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
            fileWriter.close();
            log.info("Координата записана " + pointDTO.toString());
        }
//        try {
//            PrintWriter printWriter = new PrintWriter(file);
//            printWriter.println(pointDTO.toString());
//            log.info("Координата записана в файл - " + coordinates);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
