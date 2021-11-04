package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.entity.Fournisseur;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends CrudRepository<Fournisseur, Long>{

}
