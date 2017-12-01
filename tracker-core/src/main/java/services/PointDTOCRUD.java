package services;

import dao.repo.PointDTORepository;
import jnksh.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointDTOCRUD {

    @Autowired
    private PointDTORepository pointDTORepository;

    public void delete(PointDTO point) {
        pointDTORepository.delete(point);
    }

    public void update(PointDTO point, double lat, double lon, String autoID) {
        point.setLat(lat);
        point.setLon(lon);
        point.setAutoId(autoID);
        pointDTORepository.save(point);
    }

    public PointDTO read(int id) {
        return pointDTORepository.findOne(id);

    }

    public PointDTO create(PointDTO point) {
        PointDTO pointset = new PointDTO();
        pointset.setLat(point.getLat());
        pointset.setLon(point.getLon());
        pointset.setAutoId(point.getAutoId());
        return pointDTORepository.save(pointset);
    }
}
