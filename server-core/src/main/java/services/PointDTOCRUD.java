package services;

import dao.repo.PointDTORepository;
import jnksh.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PointDTOCRUD {

    private ArrayList<PointDTO> list = new ArrayList<>();

    private PointDTORepository pointDTORepository;

    public PointDTOCRUD(@Autowired PointDTORepository pointDTORepository) {
        this.pointDTORepository = pointDTORepository;
    }

    public PointDTOCRUD() {

    }

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


    public ArrayList<PointDTO> getFiveLast() {
        System.out.println("11");
        list.add(pointDTORepository.findOne((int)pointDTORepository.count()));
        list.add(pointDTORepository.findOne((int)pointDTORepository.count()-1));
        list.add(pointDTORepository.findOne((int)pointDTORepository.count()-2));
        list.add(pointDTORepository.findOne((int)pointDTORepository.count()-3));
        list.add(pointDTORepository.findOne((int)pointDTORepository.count()-4));

        return list;
    }

    public int count() {
        return (int)pointDTORepository.count();
    }
}

