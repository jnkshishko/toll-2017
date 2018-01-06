package controllers;

import jnksh.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import services.PointDTOCRUD;

import java.io.IOException;
import java.util.List;

@RestController
public class RouteInformationController {

    private List<PointDTO> list;
    private String response;


    @Autowired
    public PointDTOCRUD crud;

    private static final Logger log = LoggerFactory.getLogger(ReceiveController.class);

    @RequestMapping(name = "/getLastPoints", method = RequestMethod.POST)
    public String getLastPoints(@RequestBody String str) {

        list = crud.getLastChosenPoints(5);
        try {
            response = list.get(0).toJson() +
                    list.get(1).toJson() +
                    list.get(2).toJson() +
                    list.get(3).toJson() +
                    list.get(4).toJson();
        } catch (IOException e) {
            log.info(e.getMessage());
        }

        return response;

    }

}
