package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entity.Facture;

@Repository
public interface FactureRepository extends CrudRepository<Facture, Long>{
	
}
