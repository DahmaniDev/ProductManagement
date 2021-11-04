package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.entity.DetailFacture;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailFactureRepository extends CrudRepository<DetailFacture, Long>{

}
