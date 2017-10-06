package jnksh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service
public class GPSService {



    @Autowired
    private GPSToolService gpsToolService;

    @Autowired
    private DataPeekService peekService;

    @PostConstruct
    public void init() {
        gpsToolService.getGPS();
    }

}
