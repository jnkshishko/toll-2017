package dao.repo;

import jnksh.PointDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface PointDTORepository extends CrudRepository<PointDTO, Integer>,
        PagingAndSortingRepository<PointDTO, Integer>,
        JpaRepository<PointDTO, Integer> {
}
