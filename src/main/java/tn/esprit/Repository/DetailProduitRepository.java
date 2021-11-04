package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.entity.DetailProduit;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailProduitRepository extends CrudRepository<DetailProduit,Long>{

}
