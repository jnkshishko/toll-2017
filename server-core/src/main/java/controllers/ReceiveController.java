package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import services.WriteToFile;

import java.io.*;


@RestController
public class ReceiveController {

    @Autowired
    public WriteToFile writeToFile;

    private static final Logger log = LoggerFactory.getLogger(ReceiveController.class);

    @RequestMapping(value = "/coordinates", method = RequestMethod.PUT)
    public void receiveCoords(@RequestBody String coordinates) throws IOException {
        log.info(coordinates);
//        ObjectMapper mapper = new ObjectMapper();
//        PointDTO pointDTO = mapper.readValue(coordinates, PointDTO.class);
//        log.info(pointDTO.toString());
        writeToFile.write(coordinates);
        }


}
