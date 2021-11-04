package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.entity.Produit;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Long>{
	
}
