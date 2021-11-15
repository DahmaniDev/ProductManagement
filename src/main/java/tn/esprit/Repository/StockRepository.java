package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entity.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock,Long>{

}
