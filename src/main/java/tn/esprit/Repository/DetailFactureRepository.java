package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entity.DetailFacture;

@Repository
public interface DetailFactureRepository extends CrudRepository<DetailFacture, Long>{

}
