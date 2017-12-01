package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import jnksh.PointDTO;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MapperPointDTO {

    private static final Logger log = LoggerFactory.getLogger(MapperPointDTO.class);

    private PointDTO point = new PointDTO();

    public PointDTO mapping (String coords) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            point = mapper.readValue(coords, PointDTO.class);
        } catch (IOException e) {
            log.info(e.getMessage());
        }
        return point;
    }

}
