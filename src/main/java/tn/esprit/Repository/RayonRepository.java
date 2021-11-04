package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.entity.Rayon;
import org.springframework.stereotype.Repository;

@Repository
public interface RayonRepository extends CrudRepository<Rayon,Long>{

}
