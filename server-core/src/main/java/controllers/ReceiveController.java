package controllers;

import jnksh.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import services.MapperPointDTO;
import services.PointDTOCRUD;

import java.io.*;


@RestController
public class ReceiveController {

    private PointDTO newPoint = new PointDTO();

    @Autowired
    private MapperPointDTO mapper;

    @Autowired
    private PointDTOCRUD crud;

    private static final Logger log = LoggerFactory.getLogger(ReceiveController.class);

    @RequestMapping(value = "/coordinates", method = RequestMethod.POST)
    public String receiveCoords(@RequestBody String coordinates) throws IOException {
//        log.info(coordinates);
//        writeToFile.write(coordinates);
        newPoint = mapper.mapping(coordinates);
        crud.create(newPoint);
        return "{status: ok}";
        }


}
