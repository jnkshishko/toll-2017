package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


@RestController
public class ReceiveController {

    private static final Logger log = LoggerFactory.getLogger(ReceiveController.class);

    @RequestMapping(value = "/coordinates", method = RequestMethod.PUT)
    public void receiveCoords(@RequestBody String coordinates) throws IOException {
        log.info(coordinates);
//        ObjectMapper mapper = new ObjectMapper();
//        PointDTO pointDTO = mapper.readValue(coordinates, PointDTO.class);
//        log.info(pointDTO.toString());
//        File file = new File("classpath:/outGPSCoordinates.txt");
//        PrintWriter printWriter = new PrintWriter(file);
//        printWriter.print(coordinates);
//        printWriter.print("\n");
//        printWriter.close();
    }

}
