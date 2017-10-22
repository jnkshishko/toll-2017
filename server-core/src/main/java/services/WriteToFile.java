package services;

import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class WriteToFile {

    public void write(String coordinates) throws IOException {
        File file = new File("/gps.txt");
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(coordinates);
            bufferedWriter.write("\n");
            bufferedWriter.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
